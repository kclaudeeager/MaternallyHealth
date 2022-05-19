import {Fragment} from "react";
import {useState} from "react";
import {Button, Form, Modal} from "react-bootstrap";

export default function AddBaby(){
    const [showAddBaby, setShowAddBaby] = useState(false);

    const handleClose = () => setShowAddBaby(false);
    const handleShow = () => setShowAddBaby(true);
    return(
        <Fragment>
            <Modal show={showAddBaby} onHide={handleClose}
                   backdrop="static"
                   keyboard={false}
                   className={"w-100"}>
                <Modal.Header closeButton>
                    <Modal.Title>add new Baby</Modal.Title>
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
                            <Form.Label className={"col-12 col-md-4"}>height</Form.Label>
                            <div className={"col-12 col-md-8"}>
                                <Form.Control type="number" placeholder="enter height" />
                            </div>

                        </Form.Group>
                        <Form.Group className="mb-3 row" controlId="formBasicEmail">
                            <Form.Label className={"col-12 col-md-4"}>weight</Form.Label>
                            <div className={"col-12 col-md-8"}>
                                <Form.Control type="tel" placeholder="enter weight" />
                            </div>

                        </Form.Group>
                        <Form.Group className="mb-3 row" controlId="formBasicEmail">
                            <Form.Label className={"col-12 col-md-4"}>Born Date</Form.Label>
                            <div className={"col-12 col-md-8"}>
                                <Form.Control type="date" placeholder="Choose date" />
                            </div>

                        </Form.Group>
                        <Form.Group className="mb-3 row" controlId="formBasicEmail">
                            <Form.Label className={"col-12 col-md-4"}>status</Form.Label>
                            <div className={"col-12 col-md-8"}>
                                <Form.Control type="number" placeholder="enter height" />
                                <Form.Text className="text-muted">
                                    how child is now.
                                </Form.Text>
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




            <button onClick={handleShow} className="btn btn-primary">Add child</button>
        </Fragment>
    )
}