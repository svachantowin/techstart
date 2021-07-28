import React, { useEffect, useState } from 'react'
import Mystyle from "./mystyles.css"

export default function FetchComponent({login}){
    const [data, setData] = useState(null)
    useEffect(() =>{
        fetch(`https://api.github.com/users/${login}`)
        .then(res => res.json())
        .then(setData)
        .catch(console.error);
    },[]);    

    const style ={
        display: "flex",
        justifyContent: "flex-end",
        color:"rebeccaPurple",
        backgroundColor:"yellow",
        padding: "10px",        
        textAlign: "left"
    }

    if(data){
        return <div> 
                <h1 className="app-header"> {data.login}</h1>
                <img className="app-image" src={data.avatar_url} /> 
            </div>
    }
    return null;
}