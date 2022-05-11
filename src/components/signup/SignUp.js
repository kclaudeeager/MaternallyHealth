import React from "react";
import logo from "../assets/img/logo.svg"
import "../login/login.css"


export default function SignUp(){
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
                    <form>
                        <div className="form-group mb-3"><label className="form-label text-secondary textLabel"
                                                                data-aos="zoom-in" data-aos-delay="100"
                                                                data-aos-once="true">Email</label><input
                            className="form-control" type="text" data-aos="zoom-in" data-aos-delay="100"
                            data-aos-once="true" required="" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,15}$"
                            inputMode="email"/></div>
                        <div className="form-group mb-3"><label className="form-label text-secondary textLabel"
                                                                data-aos="zoom-in" data-aos-delay="100"
                                                                data-aos-once="true">Name</label><input
                            className="form-control" type="text" data-aos="zoom-in" data-aos-delay="100"
                            data-aos-once="true" required=""
                            inputMode="text"/></div>

                        <div className="form-group mb-3"><label className="form-label text-secondary textLabel"
                                                                data-aos="zoom-in" data-aos-delay="150"
                                                                data-aos-once="true">Password</label><input
                            className="form-control" type="password" data-aos="zoom-in" data-aos-delay="200"
                            data-aos-once="true" required=""/></div>
                        <div className="row justify-content-end" data-aos="slide-right" data-aos-once="true">
                            <div className="col-auto align-self-center text-center">
                                <button className="btn btn-danger d-flex outline loginBtn"
                                        data-bss-hover-animate="rubberBand" type="button">Sign Up
                                </button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>)
}