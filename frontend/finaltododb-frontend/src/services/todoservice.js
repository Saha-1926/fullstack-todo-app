import axios from "axios";

const REST_API_BASE_URL = "http://localhost:8081/api/todos";

// ✅ GET all todos
export const listTodos = () => {
  return axios.get(REST_API_BASE_URL);
};

// ✅ CREATE todo
export const createTodo = (todo) => {
  return axios.post(REST_API_BASE_URL, todo);
};

// ✅ UPDATE todo (for checkbox)
export const updateTodo = (id, todo) => {
  return axios.put(`${REST_API_BASE_URL}/${id}`, todo);
};
export const deleteTodo = (id) => {
  return axios.delete(`${REST_API_BASE_URL}/${id}`);
};