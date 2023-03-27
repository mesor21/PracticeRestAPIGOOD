import React from 'react'
import logo from './logo.svg';
import {BrowserRouter, Route, Routes, Switch} from "react-router-dom";
import './App.css';
import MainPage from './component/admin/mainPage';
import EditLighting from './component/admin/editLighting';

function App() {
  return (
      <BrowserRouter>
        <Switch>
          <Route path="" element={MainPage}/>
          <Route path="/editLighting" element={EditLighting}/>
        </Switch>
      </BrowserRouter>
  );
}

export default App;
