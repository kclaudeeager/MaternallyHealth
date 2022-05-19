import {Fragment, useState} from "react";
import {Button, Form} from "react-bootstrap";

export default function SingleStaff(){
    const [isEditOn, setEditOn] = useState(false)
    return(
        <Fragment>
            <div className={"mb-5 pt-5"}>
                <div className="container">
                    <div className="main-body">
                        <div className="row gutters-sm">
                            <div className="col-md-4 mb-3">
                                <div className="card">
                                    <div className="card-body">
                                        <div className="d-flex flex-column align-items-center text-center">
                                            <img src="https://www.inventicons.com/uploads/iconset/440/wm/512/Office_Staff-88.png" alt="Admin"
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
                                                title
                                            </h6>
                                            <span className="text-secondary">assistant</span>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                            <div className="col-md-8">
                                <div className="card mb-3">
                                    <Form className="">

                                        <div className="card-body">
                                            <div className="row">
                                                <div className="col-sm-3">
                                                    <h6 className="mb-0">First Name</h6>
                                                </div>
                                                <div className="col-sm-9 text-secondary">
                                                    {isEditOn?(<Form.Control type="text" placeholder="Enter FirstName" />):("aline")}

                                                </div>
                                            </div>
                                            <hr />
                                            <div className="row">
                                                <div className="col-sm-3">
                                                    <h6 className="mb-0">Last Name</h6>
                                                </div>
                                                <div className="col-sm-9 text-secondary">
                                                    {isEditOn?(<Form.Control type="text" placeholder="Enter second Name" />):("ruhumuriza")}

                                                </div>
                                            </div>
                                            <hr />
                                            <div className="">
                                                <div className="row">
                                                    <div className="col-sm-3">
                                                        <h6 className="mb-0">Title</h6>
                                                    </div>
                                                    <div className="col-sm-9 text-secondary">
                                                        {isEditOn?(<Form.Control type="text"  placeholder="Enter title" />):("assistant")}
                                                    </div>
                                                </div>
                                                <hr />
                                                <div className="row">
                                                    <div className="col-sm-3">
                                                        <h6 className="mb-0">Email</h6>
                                                    </div>
                                                    <div className="col-sm-9 text-secondary">
                                                        {isEditOn?(<Form.Control type="email" placeholder="Enter Email" />):("kwizera@gmail.com")}
                                                    </div>
                                                </div>
                                                <hr />
                                                <div className="row">
                                                    <div className="col-sm-3">
                                                        <h6 className="mb-0">phoneNumber</h6>
                                                    </div>
                                                    <div className="col-sm-9 text-secondary">
                                                        {isEditOn?(<Form.Control type="number" placeholder="Enter phone" />):("0789876543")}
                                                    </div>
                                                </div>
                                                <hr />
                                                <div className="row">
                                                    <div className="col-sm-3">
                                                        <h6 className="mb-0">Department</h6>
                                                    </div>
                                                    <div className="col-sm-9 text-secondary">
                                                        {isEditOn?(<Form.Control type="text" placeholder="Enter department" />):("Ababyaza")}
                                                    </div>
                                                </div>
                                                <hr />
                                                {isEditOn?(<div className="row">
                                                    <div className="col-sm-6">
                                                        <Button onClick={() => {
                                                            setEditOn(false)
                                                        }} className="btn btn-info "
                                                        >Cancel</Button>
                                                    </div>
                                                    <div className="col-sm-6">
                                                        <Button onClick={() => {
                                                            setEditOn(false)
                                                        }} className="btn btn-info "
                                                        >Save</Button>
                                                    </div>
                                                </div>):(<div className="row">
                                                    <div className="col-sm-12">
                                                        <Button onClick={() => {
                                                            setEditOn(true)
                                                        }} className="btn btn-info "
                                                        >Edit</Button>
                                                    </div>
                                                </div>)}

                                            </div>
                                        </div>



                                    </Form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </Fragment>
    )
}
