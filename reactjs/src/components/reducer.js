import React, { useReducer } from 'react';

export default function ReducerCheckBox(){
    const [checked,toggle] = useReducer(checked => !checked,false);

    return(
        <div>
            <input type="checkbox"
            value = {checked}
            onChange= {toggle}/>
            {checked ? "Checked" : "Unchecked"}
        </div>
    )

}