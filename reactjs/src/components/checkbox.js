import React, { useEffect, useState } from 'react';

function Checkbox(){
    const [checked,setChecked] = useState(false);
    const [val1,setVal1] = useState("");
    useEffect(() =>{
        console.log("Value :",val1)
    },[val1])

    return(
        <>
            <input type="checkbox" 
                value={checked} 
                onChange={() => setChecked(checked => !checked)}/>
            {checked ? "Checked ": "Unchecked"}

            <input value={val1}
                onChange={e => setVal1(e.target.value)}/>
            
        </>
    )

}

export default Checkbox;