import React from 'react';

function Lake({lakes}){
    return(
        <ul>
            {
                lakes.map((lake,itr) => (
                    
                    <div key={itr}>
                        {itr%2===0 
                            ?<>
                                <li > {lake.name}</li>
                                <p> Desc :{lake.desc}</p>
                            </>
                            :<>
                                <h1> It is odd number</h1>
                            </>
                            }
                        
                    </div>
                ))}

        </ul>
    )
}

export default Lake;