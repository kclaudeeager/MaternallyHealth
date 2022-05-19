import {Fragment} from "react";
import {Button} from "react-bootstrap";

export default function BabyTab(){
    return(
        <Fragment>
            <div>
                <div className="container">
                    <div className="main-body">
                        <div className="row gutters-sm">
                            <div className="col-md-4 mb-3">
                                <div className="card">
                                    <div className="card-body">
                                        <div className="d-flex flex-column align-items-center text-center">
                                            <img src="https://cdn5.vectorstock.com/i/1000x1000/73/59/cute-and-happy-little-black-baby-vector-32267359.jpg" alt="Admin"
                                                 className="rounded-circle" width="150" />
                                            <div className="mt-3">
                                                <h4>viviane</h4>
                                                <p className="text-secondary mb-1"> live in kigali</p>
                                                <p className="text-muted font-size-sm">nyamirambo</p>
                                                <button className="btn btn-outline-primary">Delete</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div className="card mt-3">
                                    <ul className="list-group list-group-flush">
                                        <li className="list-group-item d-flex justify-content-between align-items-center flex-wrap">
                                            <h6 className="mb-0">
                                                born date
                                            </h6>
                                            <span className="text-secondary">23/03/2023</span>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                            <div className="col-md-8">
                                <div className="card mb-3">
                                    <div className="card-body">
                                        <div className="row">
                                            <div className="col-sm-3">
                                                <h6 className="mb-0">First Name</h6>
                                            </div>
                                            <div className="col-sm-9 text-secondary">
                                                aline
                                            </div>
                                        </div>
                                        <hr />
                                        <div className="card-body">
                                            <div className="row">
                                                <div className="col-sm-3">
                                                    <h6 className="mb-0">Last Name</h6>
                                                </div>
                                                <div className="col-sm-9 text-secondary">
                                                    ruhumuriza
                                                </div>
                                            </div>
                                            <hr />
                                            <div className="card-body">
                                                <div className="row">
                                                    <div className="col-sm-3">
                                                        <h6 className="mb-0">born date</h6>
                                                    </div>
                                                    <div className="col-sm-9 text-secondary">
                                                        23/12/2023
                                                    </div>
                                                </div>
                                                <hr />
                                        <div className="row">
                                            <div className="col-sm-3">
                                                <h6 className="mb-0">Height</h6>
                                            </div>
                                            <div className="col-sm-9 text-secondary">
                                                0.3 m
                                            </div>
                                        </div>
                                        <hr />
                                        <div className="row">
                                            <div className="col-sm-3">
                                                <h6 className="mb-0">weight</h6>
                                            </div>
                                            <div className="col-sm-9 text-secondary">
                                                3 kg
                                            </div>
                                        </div>
                                        <hr />

                                        <hr />
                                        <div className="row">
                                            <div className="col-sm-3">
                                                <h6 className="mb-0">status</h6>
                                            </div>
                                            <div className="col-sm-9 text-secondary">
                                                good
                                            </div>
                                        </div>
                                        <hr/>
                                        <div className="row">
                                            <div className="col-sm-12">
                                                <Button className="btn btn-info "
                                                        href="">Edit</Button>
                                            </div>
                                        </div>
                                    </div>
                                </div>



                            </div>
                        </div>
                    </div>
                </div>
                    </div>
                </div>

            </div>
        </Fragment>
    )
}