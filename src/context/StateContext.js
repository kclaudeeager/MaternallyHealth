import {createContext, useEffect, useState} from "react";
import config from "../config";
import axios from "axios";

const StateContext = createContext();
export default StateContext;

export function StateProvider({children}){

    const [currentTab, setCurrentTab] = useState("");
    const [hospitalFetch, setHospitalFetch] = useState({status:config.status.NOTHING,data:[]})

    useEffect(() => {
        fetchHospitals();
    },[])

    function fetchxHospitals(){

        var myHeaders = new Headers();
        myHeaders.append("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2NTI5NTU1NjAsImV4cCI6MTY1Mjk1OTE2MCwidXNlcklkIjoxLCJlbWFpbCI6ImNsYXVkZWt3aXplcmEwMDNAZ21haWwuY29tIiwiZmlyc3ROYW1lIjoiS3dpemVyYSIsImxhc3ROYW1lIjoiQ2xhdWRlIiwicm9sZSI6IkFETUlOIn0.FyEwjOQiQUTNUmCu44utkTG0nkgX2pAUbMaKOlvO97c");

        var requestOptions = {
            method: 'GET',
            headers: myHeaders,
            redirect: 'follow'
        };
        var corsLink="https://cors-anywhere.herokuapp.com/";
        fetch("https://maternally-health-backend.herokuapp.com/api/v1/staffs/hospital/1", requestOptions)
            .then(response => response.text())
            .then(result => {console.log(result);
                document.getElementById("allHospital").innerHTML=result;})
            .catch(error => console.log('error', error));


    }


    async function fetchHospitals(data){
        const token = "eyJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2NTI5NzUxOTAsImV4cCI6MTY1Mjk3ODc5MCwidXNlcklkIjozLCJlbWFpbCI6InBhdGVybmVudWdodEBnbWFpbC5jb20iLCJmaXJzdE5hbWUiOiJwYXRlcm5lIiwibGFzdE5hbWUiOiJudWdodCIsInJvbGUiOiJOT05FIn0.MFrBHgrPApz9ev977WArk9iA9xSJb8dfWCKNtPt9j7Q"
        // const configs = {
        //     headers: { 'Authorization': `Bearer ${token}` }
        // };
        // const instance = axios.create({
        //     baseURL: 'https://maternally-health-backend.herokuapp.com/api/v1/',
        //     headers: {'Authorization': 'Bearer '+token}
        // });

        axios("https://maternally-health-backend.herokuapp.com/api/v1/hospital/all", { headers: {"Authorization" : `Bearer ${token}`} }).then((resp)=>{
            console.log("result: ",resp)
        }).catch((error)=>{
            console.log("eroor:",error.message)
        })

        // console.log(JSON.stringify({...data}));
        //setHospitalFetch({...hospitalFetch, status: config.status.LOADING});
        // return instance.get("hospital/all")
        //     .then(function (response) {
        //         if(response.status === 201 || response.status === 200){
        //             console.log(response.data);
        //             //setHospitalFetch({payload: {...response.data}, status: config.status.DONE});
        //             return {payload: {...response.data}, status: config.status.DONE}
        //         }
        //         else {
        //             //setHospitalFetch({payload: {...response.data}, status: config.status.ERROR});
        //             return {payload: {...response.data}, status: config.status.ERROR}
        //         }
        //
        //     }).then((output) => {
        //         return {...output}
        //     })
        //     .catch(function (error) {
        //         console.log(error)
        //         console.log("before error")
        //         //setHospitalFetch({payload: {...error.response.data}, status: config.status.ERROR});
        //         return {payload: {...error}, status: config.status.ERROR}
        //     });
    }
    return (
        <StateContext.Provider value={{currentTab, setCurrentTab}}>
            {children}
        </StateContext.Provider>
    )
}