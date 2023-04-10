import React from 'react'

import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';
import './App.css';
import MainPage from './component/admin/mainPage';
import EditLighting from './component/admin/editLighting';

function App(){
  return(
  <Router>
      <Switch>
        <Route exact path= '/' component={MainPage} />
        <Route exact path= '/edit/**' component={EditLighting} /> 
      </Switch>
  </Router>);
}

export default App;
