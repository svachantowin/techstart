import React, { useContext, useReducer } from 'react';
import { UserContext } from './context';


export default function ContextCheckbox(){
    const [checked,toggle] = useReducer(checked => !checked,false);
    const {userInfo} = useContext(UserContext);
    console.log(userInfo);

    return(
        <div>
            <input type="checkbox"
            value = {checked}
            onChange= {toggle}/>
            {checked ? "Checked " : "Unchecked"}{" by " + userInfo.name}
        </div>
    )

}