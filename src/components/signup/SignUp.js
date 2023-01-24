import React, {useState} from "react";
import logo from "../assets/img/logo.svg"
import "../login/login.css";
import axios from "axios";
import swal from "sweetalert";
import joi from "joi";
import {useForm} from "react-hook-form";
import {joiResolver} from "@hookform/resolvers/joi";
import Constants from "../../system/constants";
import { formatJoiErorr } from "../../system/format";
import { useNavigate } from "react-router-dom";


const fields = {
    email: joi.string().required(),
    firstName: joi.string().required(),
    lastName: joi.string().required(),
    password: joi.string().required(),
    confirmPassword: joi.string()
    .valid(joi.ref('password'))
    .required()
    .messages({
        'any.only': 'Confirm Password must match with Password',
    })
};

const schema = joi.object(fields);

export default function SignUp(){
    const [loading, setLoading] = useState(false);
    const navigate=useNavigate();
    const {
        register,
        handleSubmit,
        setValue,
        getValues,
        reset,
        formState: { errors },
    } = useForm({
        resolver: joiResolver(schema),
    });

    const onSubmit = async (query) => {
        setLoading(!loading)
        delete query.confirmPassword;
        axios.post(Constants.BACKEND_URL + Constants.endpoints.SIGNUP, {...query})
          .then(response => {
            setLoading(!loading)
            swal('Signup successfully!', response.data, 'success').then(()=>reset()).then(()=>{
                setLoading(false);
                navigate('/login')
                // reset();
            });
          })
          .catch(error => {
            setLoading(!loading)
            swal('Signup fail!', error.response.data.message || "Fail to signup", 'error').then(()=>{
                setLoading(false);
                // reset(); 
            });
          });
      }

    return(<div className="container-fluid loginContainer"
    >
        <div className="row mh-100vh">
            <div
                className="col-12 col-sm-8 col-md-6 col-lg-6 offset-sm-2 offset-md-3 offset-lg-3 align-self-center d-lg-flex align-items-lg-center align-self-lg-stretch p-5 rounded rounded-lg-0 my-5 my-lg-0 my-box-shadow"
                data-aos="zoom-in" data-aos-once="true">
                <div className="m-auto w-lg-75 w-xl-50 loginContainer">
                    <div className="row justify-content-center loginDivContainer">
                        <div className="col-auto align-items-center align-content-center logoDiv"><img
                            className="imageLogo" src={logo}/></div>
                    </div>
                    <form onSubmit={event => {
                            handleSubmit(onSubmit)(event);
                        }}>
                        <div className="form-group mb-3"><label className="form-label text-secondary textLabel"
                                                                data-aos="zoom-in" data-aos-delay="100"
                                                                data-aos-once="true">Email</label>
                                {errors.email?.message && (
                                    <p className="mt-1 text-red-500">
                                        {formatJoiErorr(`${errors.email.message}`)}
                                    </p>
                                )}
                            <input
                            className="form-control" type="text" data-aos="zoom-in" data-aos-delay="100"
                            data-aos-once="true" required="" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,15}$"
                            inputMode="email" {...register("email")}/></div>

                        <div className="form-group mb-3"><label className="form-label text-secondary textLabel"
                                                                data-aos="zoom-in" data-aos-delay="100"
                                                                data-aos-once="true">First Name</label>
                            {errors.firstName?.message && (
                                <p className="mt-1 text-red-500">
                                    {formatJoiErorr(`${errors.firstName.message}`)}
                                </p>
                            )}                                    
                            <input
                            className="form-control" type="text" data-aos="zoom-in" data-aos-delay="100"
                            data-aos-once="true" required=""
                            inputMode="text" {...register("firstName")}/></div>

                            <div className="form-group mb-3"><label className="form-label text-secondary textLabel"
                                                                data-aos="zoom-in" data-aos-delay="100"
                                                                data-aos-once="true">Last Name</label>
                            {errors.lastName?.message && (
                                <p className="mt-1 text-red-500">
                                    {formatJoiErorr(`${errors.lastName.message}`)}
                                </p>
                            )}                                    
                            <input
                            className="form-control" type="text" data-aos="zoom-in" data-aos-delay="100"
                            data-aos-once="true" required=""
                            inputMode="text" {...register("lastName")}/></div>

                        <div className="form-group mb-3"><label className="form-label text-secondary textLabel"
                                                                data-aos="zoom-in" data-aos-delay="150"
                                                                data-aos-once="true">Password</label>
                        {errors.password?.message && (
                            <p className="mt-1 text-red-500">
                                {formatJoiErorr(`${errors.password.message}`)}
                            </p>
                        )}
                        <input
                            className="form-control" type="password" data-aos="zoom-in" data-aos-delay="200"
                            data-aos-once="true" required="" {...register("password")}/></div>
                        <div className="form-group mb-3"><label className="form-label text-secondary textLabel"
                                                                data-aos="zoom-in" data-aos-delay="150"
                                                                data-aos-once="true">Confirm Password</label>
                            {errors.confirmPassword?.message && (
                                <p className="mt-1 text-red-500">
                                    {formatJoiErorr(`${errors.confirmPassword.message}`)}
                                </p>
                            )}
                            <input
                            className="form-control" type="password" data-aos="zoom-in" data-aos-delay="200"
                            data-aos-once="true" {...register("confirmPassword")}/></div>
                        <div className="row justify-content-end" data-aos="slide-right" data-aos-once="true">
                            <div className="col-auto align-self-center text-center">
                                <button className="btn btn-danger d-flex outline loginBtn"
                                        data-bss-hover-animate="rubberBand" type="submit">{!loading?<>Sign Up</>:<>Loading...</>}
                                </button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>)
}