import React, {useEffect, useState} from "react";
import Secure from "../../system/helpers/secureLs";
import Keys from "../../system/constants/keys";
import axios from "axios";
import Constants from "../../system/constants";

export const defaultValue = {
    profile: undefined,
    setProfile(){},
};
export const useData = () => {
    return React.useContext(DataContext);
};

export const DataContext = React.createContext(defaultValue);

const DataProvider = ({children}) =>{
    const [profile, setProfile] = useState(undefined)

    React.useEffect(() =>{
        const user = Secure.get(Keys.USER_INFO );
        if (user) {
            setProfile((prev) => {
                if (!prev) {
                    return user;
                }
                return prev;
            });
        }
    }, [])

    const value = React.useMemo(()=>{
        return {
            profile,setProfile,
        }
    }, [profile])

    return (
        <DataContext.Provider value={value}>
            {children}
        </DataContext.Provider>
    )
}

export default DataProvider