import React, { useState } from 'react';
import { createTodo } from '../services/todoservice';
import { useNavigate } from 'react-router-dom';

const TodoComponent = () => {

    const [title, setTitle] = useState('');
    const [description, setDescription] = useState('');
    const [completed, setCompleted] = useState(false);

    const navigate = useNavigate();

    const saveTodo = (e) => {
        e.preventDefault();

        const todo = {
            title,
            description,
            completed
        };

        createTodo(todo)
            .then((response) => {
                console.log(response.data);
                navigate('/todos'); // go back to list page
            })
            .catch(error => {
                console.error(error);
            });
    };

    return (
        <div className='container'>

            <h2 className='text-center mb-4'>Add Todo</h2>

            <form>

                {/* TITLE */}
                <div className='form-group mb-3'>
                    <label className='form-label'>Title</label>
                    <input
                        type='text'
                        placeholder='Enter Title'
                        className='form-control'
                        value={title}
                        onChange={(e) => setTitle(e.target.value)}
                    />
                </div>

                {/* DESCRIPTION */}
                <div className='form-group mb-3'>
                    <label className='form-label'>Description</label>
                    <input
                        type='text'
                        placeholder='Enter Description'
                        className='form-control'
                        value={description}
                        onChange={(e) => setDescription(e.target.value)}
                    />
                </div>

              

                {/* BUTTON */}
                <button className='btn btn-success' onClick={saveTodo}>
                    Submit
                </button>

            </form>

        </div>
    );
};

export default TodoComponent;