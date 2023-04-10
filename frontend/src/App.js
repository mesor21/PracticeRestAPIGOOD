import React from 'react'

import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';
import './App.css';
import MainPage from './component/admin/mainPage';

function App(){
  return(
  <Router>
      <Switch>
        <Route exact path= '/' component={MainPage} /> 
      </Switch>
  </Router>);
}

export default App;
