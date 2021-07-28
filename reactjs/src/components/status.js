import React,{useState} from 'react';

function Status(){
    const [myState,setStatus] = useState("Open");
    return(
        <div>
            <h1> Rendering status : {myState} </h1>
            <button onClick={()=> setStatus("Closed")}> 
                Close
            </button>
            <button onClick={()=> setStatus("Open")}> 
                Open
            </button>
            <button onClick={()=> setStatus("Back in 5")}> 
                Break
            </button>
        </div>
    )

}

export default Status;