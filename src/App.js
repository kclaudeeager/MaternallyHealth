import logo from './logo.svg';
import './App.css';
import {Route,BrowserRouter as Router, Routes} from "react-router-dom";
import 'bootstrap/dist/css/bootstrap.css'
import * as PropTypes from "prop-types";
import AppRoutes from "./AppRoutes";
import routes from './pages'
function Providers(props) {
  return null;
}

Providers.propTypes = {children: PropTypes.node};

function App() {
  return (
      <Router>
          <AppRoutes routes={routes} />
      </Router>
  );
}

export default App;
