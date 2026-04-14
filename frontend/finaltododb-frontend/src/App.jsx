import './App.css';
import HeaderComponent from './component/headercomponent';
import FooterComponent from './component/footercomponent';
import ListTodoComponent from './component/ListTodoComponent';
import TodoComponent from './component/TodoComponent';

import { BrowserRouter, Routes, Route } from 'react-router-dom';

function App() {
  return (
    <BrowserRouter>

      <HeaderComponent />

      <Routes>

        {/* http://localhost:3000 */}
        <Route path="/" element={<ListTodoComponent />} />

        {/* http://localhost:3000/todos */}
        <Route path="/todos" element={<ListTodoComponent />} />
          <Route path='/add-todo' element={<TodoComponent />} />

      </Routes>

      <FooterComponent />

    </BrowserRouter>
  );
}

export default App;