import {createContext, useState} from "react";
import config from "../config";

const StateContext = createContext();
export default StateContext;

export function StateProvider({children}){

    const [currentTab, setCurrentTab] = useState("");



    return (
        <StateContext.Provider value={{currentTab, setCurrentTab}}>
            {children}
        </StateContext.Provider>
    )
}