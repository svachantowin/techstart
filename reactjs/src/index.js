import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import MyReactComponent from './components/testcomponent';
import Lake from './components/lakes';
import Status from './components/status';
import Checkbox from './components/checkbox';
import FetchComponent from './components/fetch';
import ReducerCheckBox from './components/reducer';
import { UserContext } from './components/context';
import ContextCheckbox from './components/ContextCheckbox';
import SearchList from './components/search';
import LazyLoad from './components/lazyloading';

function HelloReact() {
  return (<h1> Welcome to react  </h1>);
}

const lakeList = [
  "Lake 1",
  "Lake 2",
  "Lake 3",
  "Lake 4",
];

const lakeObjects = [
  {id:"1",name:"Lake 1",desc:"something 1"},
  {id:"2",name:"Lake 2",desc:"something 2"},
  {id:"3",name:"Lake 3",desc:"something 3"},
  {id:"4",name:"Lake 4",desc:"something 4"},
];

const userInfo = {
  name: "Siva",
  id: 1
}

ReactDOM.render(
  // <React.StrictMode>
  //   <App />
  // </React.StrictMode>
  // <HelloReact/>   
  // <MyReactComponent 
  //     library="React"
  //     message ="Test React"
  //     number = {3}
  // />
  // <Lake lakes={lakeObjects}/>
  // <Status/>
  // <Checkbox/>
  // <FetchComponent login="svachantowin"/>
  // <ReducerCheckBox/>
  // <UserContext.Provider value={{userInfo}}>
  //   <ContextCheckbox/>
  
  // </UserContext.Provider>

  // <SearchList/>
  <LazyLoad/>
  ,
  document.getElementById('root')
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
