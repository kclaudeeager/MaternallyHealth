import React,{Fragment} from "react";
import Layout from "../Layout";
import "./style.css"
const DashContent = () => {
    return(<Fragment>
        <div className="main_hospital">
            <div className="container-fluid">
                <div className="row">
                    <div className="col">
                        <div className="d-flex justify-content-center h-100">
                            <div className="searchbar"><input type="text" className="search_input" placeholder="Search..."/><a
                                className="search_icon" href="#"><i className="fas fa-search"></i></a></div>
                        </div>
                    </div>
                </div>
                <div className="row">
                    <div className="col">
                        <div className={"main_hospital"}>
                            <ul className="cards">

                                <li className="cards_item cards_item_hospital">
                                    <div className="card card-hospital">
                                        <div className="card_image card_image_hospital">
                                            <img src="https://www.dragarwal.com/wp-content/uploads/2021/01/Kigali-Exterior-1.jpg"
                                                 alt="mixed vegetable salad in a mason jar. "/>
                                        </div>
                                        <div className="card_content card_content_hospital w-100">
                                            <h2 className="card_title card_title_hospital">Hospital A <span>Location</span></h2>
                                            <div className="card_text card_text_hospital ">
                                                <p>content about your hospital</p>
                                                <div className={"hidingContentHospitalCard"}>
                                                    <p className={""}>more content </p>
                                                    <button className="btn btn-danger d-flex outline loginBtn"
                                                            data-bss-hover-animate="rubberBand" type="button">GO in
                                                    </button>
                                                </div>

                                            </div>
                                        </div>
                                    </div>
                                </li>




                            </ul>
                        </div>

                    </div>
                </div>
            </div>



        </div>
    </Fragment>)
}



const Hospital =() =>{
    return <Layout>
        <DashContent/>
    </Layout>
}

export default Hospital;