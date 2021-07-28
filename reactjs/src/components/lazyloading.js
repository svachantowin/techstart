import React, { Suspense } from 'react';
import FetchComponent from './fetch';


const Component1 = React.lazy(
    () => 
        new Promise((resolve,reject) => (
            setTimeout(() => resolve(import("./customcomponent")),100)
        ))    
)

const Component2 = React.lazy(
    () => new Promise((resolve,reject) =>(
        setTimeout(() =>resolve(import("./customcomponent")),5000)
    ))
)

export default function LazyLoad(){
    return(
        <>
            <FetchComponent login="svachantowin"/>
            <Suspense fallback={<div>Loading</div>}>
                <Component1 label="Component 1"/>
                <Component2 label="Component 2"/>
            </Suspense>

        </>
    )
}