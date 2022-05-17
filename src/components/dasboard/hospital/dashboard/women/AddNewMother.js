import {useState} from "react";
import {Button, Form, Modal} from "react-bootstrap";

export default function AddNewMother(){

    const [show, setShow] = useState(false);

    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);


    return(
        <div>
            <Modal show={show} onHide={handleClose}
                   backdrop="static"
                   keyboard={false}
                   fullscreen={true}
                   className={"w-100"}>
                <Modal.Header closeButton>
                    <Modal.Title>add new Mother</Modal.Title>
                </Modal.Header>
                <Modal.Body className={"w-100"}>
                    <Form className={"w-50"}>
                        <Form.Group className="mb-3 row" controlId="formBasicEmail">
                            <Form.Label className={"col-12 col-md-4"}>First Name</Form.Label>
                            <div className={"col-12 col-md-8"}>
                                <Form.Control type="text" placeholder="enter FistName" />
                            </div>

                        </Form.Group>
                        <Form.Group className="mb-3 row" controlId="formBasicEmail">
                            <Form.Label className={"col-12 col-md-4"}>Last Name</Form.Label>
                            <div className={"col-12 col-md-8"}>
                                <Form.Control type="text" placeholder="enter LastName" />
                            </div>

                        </Form.Group>
                        <Form.Group className="mb-3 row" controlId="formBasicEmail">
                            <Form.Label className={"col-12 col-md-4"}>Residance</Form.Label>
                            <div className={"col-12 col-md-8"}>
                                <Form.Control type="text" placeholder="enter Residance" />
                            </div>

                        </Form.Group>
                        <Form.Group className="mb-3 row" controlId="formBasicEmail">
                            <Form.Label className={"col-12 col-md-4"}>Tel Phone</Form.Label>
                            <div className={"col-12 col-md-8"}>
                                <Form.Control type="tel" placeholder="enter phone number" />
                            </div>

                        </Form.Group>
                        <Form.Group className="mb-3 row" controlId="formBasicEmail">
                            <Form.Label className={"col-12 col-md-4"}>Email address</Form.Label>
                            <div className={"col-12 col-md-8"}>
                                <Form.Control type="email" placeholder="Enter email" />
                                <Form.Text className="text-muted">
                                    We'll never share your email with anyone else.
                                </Form.Text>
                            </div>

                        </Form.Group>
                        <Form.Group className="mb-3 row" controlId="formBasicEmail">
                            <Form.Label className={"col-12 col-md-4"}>height</Form.Label>
                            <div className={"col-12 col-md-8"}>
                                <Form.Control type="number" placeholder="enter height" />
                                <Form.Text className="text-muted">
                                    how large is the mother.
                                </Form.Text>
                            </div>

                        </Form.Group>
                        <Form.Group className="mb-3 row" controlId="formBasicEmail">
                            <Form.Label className={"col-12 col-md-4"}>Age</Form.Label>
                            <div className={"col-12 col-md-8"}>
                                <Form.Control type="number" placeholder="enter age" />
                            </div>

                        </Form.Group>
                        <Form.Group className="mb-3 row" controlId="formBasicEmail">
                            <Form.Label className={"col-12 col-md-4"}>Weight</Form.Label>
                            <div className={"col-12 col-md-8"}>
                                <Form.Control type="number" placeholder="enter Weight" />
                            </div>

                        </Form.Group>
                        <Form.Group className="mb-3 row" controlId="formBasicEmail">
                            <Form.Label className={"col-12 col-md-4"}>Id</Form.Label>
                            <div className={"col-12 col-md-8"}>
                                <Form.Control type="number" placeholder="enter age" />
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
                                            to register Mother</h4>
                                    </div>
                                </div>
                                <div className="row">
                                    <div className="col d-inline-flex justify-content-lg-center">
                                        <button className="btn btn-primary btnAddNewMother" type="button">Add
                                            New Mother
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    )
}