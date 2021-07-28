import React from "react";


function MyReactComponent({library, message, number}) {
    // console.log(Object.keys(props));
    return (
        <div>
            <h1>My component getting rendered</h1>
            <p>Property one : {library}</p>
            <p>Property two : {message}</p>
            <p>Property three : {number}</p>
        </div>
    
    )
}
    
export default MyReactComponent;