import {Fragment, useState} from "react";
import {Button, Form, Modal} from "react-bootstrap";
import classes from "../../../../Global.module.css";

export default function AddNewConsultant({ConsultantType}){
    const [show, setShow] = useState(false);

    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);
    return(
        <Fragment>
            <Modal show={show} onHide={handleClose}
                   backdrop="static"
                   keyboard={false}
                   className={"w-100"}>
                <Modal.Header closeButton>
                    <Modal.Title>add new Consultant</Modal.Title>
                </Modal.Header>
                <Modal.Body className={"w-100"}>
                    <Form className={""}>
                        <Form.Group className="mb-3 row" controlId="formBasicEmail">
                            <Form.Label className={"col-12 col-md-4"}>description</Form.Label>
                            <div className={"col-12 col-md-8"}>
                                <Form.Control className={classes.h300} as={"textarea"}  type="text" placeholder="enter advice here" />
                            </div>

                        </Form.Group>

                    </Form>
                </Modal.Body>
                <Modal.Footer>
                    <Button variant="secondary" onClick={handleClose}>
                        Close
                    </Button>
                    <Button variant="primary" onClick={handleClose}>
                        Add
                    </Button>
                </Modal.Footer>
            </Modal>




            <div className="container">
                <div className="row">
                    <div className="col">
                        <div className="card border rounded" onClick={() => {
                            handleShow();
                        }}>
                            <div className="card-body align-items-lg-center cardRegisterMother">
                                <div className="row">
                                    <div className="col">
                                        <h4 className="text-center text-sm-center text-md-center text-lg-center text-xl-center text-xxl-center registerMotherText">click
                                            to Add Consultation</h4>
                                    </div>
                                </div>
                                <div className="row">
                                    <div className="col d-inline-flex justify-content-lg-center">
                                        <button className="btn btn-primary btnAddNewMother" type="button">Add
                                            New Consultation
                                        </button>
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