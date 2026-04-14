import React, { useEffect, useState } from "react";
import { listTodos, updateTodo, deleteTodo } from "../services/todoservice";
import { useNavigate } from "react-router-dom";

const ListTodoComponent = () => {
  const [todos, setTodos] = useState([]);
  const navigator = useNavigate();

  useEffect(() => {
    listTodos()
      .then((response) => {
        setTodos(response.data);
      })
      .catch((error) => {
        console.error(error);
      });
  }, []);

  function addNewTodo() {
    navigator("/add-todo");
  }

  // ✅ Toggle checkbox
  function handleToggle(todo) {
    const updatedTodo = {
      ...todo,
      completed: !todo.completed,
    };

    updateTodo(todo.id, updatedTodo)
      .then(() => {
        listTodos().then((res) => setTodos(res.data));
      })
      .catch((err) => console.error(err));
  }

  // ✅ Delete function
  function handleDelete(id) {
    deleteTodo(id)
      .then(() => {
        listTodos().then((res) => setTodos(res.data));
      })
      .catch((err) => console.error(err));
  }

  return (
    <div className="container">
      <h2 className="text-center">List of Todos</h2>

      <button className="btn btn-primary mb-2" onClick={addNewTodo}>
        Add Todo
      </button>

      <table className="table table-striped table-bordered">
        <thead>
          <tr>
            <th>Todo Id</th>
            <th>Title</th>
            <th>Description</th>
            <th>Completed</th>
            <th>Actions</th> {/* ✅ Added */}
          </tr>
        </thead>

        <tbody>
          {todos.map((todo) => (
            <tr key={todo.id}>
              <td>{todo.id}</td>
              <td>{todo.title}</td>
              <td>{todo.description}</td>

              <td>
                <input
                  type="checkbox"
                  checked={todo.completed}
                  onChange={() => handleToggle(todo)}
                />
              </td>

              
              <td>
                <button
                  className="btn btn-danger"
                  onClick={() => handleDelete(todo.id)}
                >
                  Delete
                </button>
              </td>

            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default ListTodoComponent;