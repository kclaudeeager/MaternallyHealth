import classes from "./Css.module.css";
import "./style.css"
import {useEffect} from "react";

export default function HomePage(){
    useEffect(() => {

    },[])
    return(
        <div>
            <div className="page-wrapper">
                <div className="header-top">
                    <div className="container">
                        <div className="row align-items-center">
                            <div className="col-md-6">
                                <div className="top-left text-center text-md-left">
                                    <h6>Opening Hours : Saturday to Tuesday - 8am to 10pm</h6>
                                </div>
                            </div>
                            <div className="col-md-6">
                                <div className="top-right text-center text-md-right">
                                    <ul className="social-links">
                                        <li>
                                            <a href="https://themefisher.com/" aria-label="facebook">
                                                <i className="fab fa-facebook-f"></i>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="https://themefisher.com/" aria-label="twitter">
                                                <i className="fab fa-twitter"></i>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="https://themefisher.com/" aria-label="google-plus">
                                                <i className="fab fa-google-plus-g"></i>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="https://themefisher.com/" aria-label="instagram">
                                                <i className="fab fa-instagram"></i>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="https://themefisher.com/" aria-label="pinterest">
                                                <i className="fab fa-pinterest-p"></i>
                                            </a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <section className="header-uper">
                    <div className="container">
                        <div className="row align-items-center">
                            <div className="col-xl-4 col-lg-3">
                                <div className="logo">
                                    <a href="index.html">
                                        <img loading="lazy" className="img-fluid" src="images/logo.png" alt="logo"/>
                                    </a>
                                </div>
                            </div>
                            <div className="col-xl-8 col-lg-9">
                                <div className="right-side">
                                    <ul className="contact-info pl-0 mb-4 mb-md-0">
                                        <li className="item text-left">
                                            <div className="icon-box">
                                                <i className="far fa-envelope"></i>
                                            </div>
                                            <strong>Email</strong>
                                            <br/>
                                                <a href="mailto:info@medic.com">
                                                    <span>info@medic.com</span>
                                                </a>
                                        </li>
                                        <li className="item text-left">
                                            <div className="icon-box">
                                                <i className="fas fa-phone"></i>
                                            </div>
                                            <strong>Call Now</strong>
                                            <br/>
                                                <span>+ (88017) - 123 - 4567</span>
                                        </li>
                                    </ul>
                                    <div className="link-btn text-center text-lg-right">
                                        <a href="contact.html" className="btn-style-one">Appoinment</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
                <nav className="navbar navbar-expand-lg navbar-dark">
                    <div className="container">
                        <button className="navbar-toggler" type="button" data-toggle="collapse"
                                data-target="#navbarLinks" aria-controls="navbarSupportedContent" aria-expanded="false"
                                aria-label="Toggle navigation">
                            <span className="navbar-toggler-icon"></span>
                        </button>

                        <div className="collapse navbar-collapse" id="navbarLinks">
                            <ul className="navbar-nav">
                                <li className="nav-item active">
                                    <a className="nav-link" href="index.html">Home</a>
                                </li>
                                <li className="nav-item @@about">
                                    <a className="nav-link" href="about.html">About</a>
                                </li>
                                <li className="nav-item @@service">
                                    <a className="nav-link" href="service.html">Service</a>
                                </li>
                                <li className="nav-item @@gallery">
                                    <a className="nav-link" href="gallery.html">Gallery</a>
                                </li>
                                <li className="nav-item @@team">
                                    <a className="nav-link" href="team.html">Team</a>
                                </li>
                                <li className="nav-item @@appointment">
                                    <a className="nav-link" href="appointment.html">Appointment</a>
                                </li>
                                <li className="nav-item dropdown @@blogs">
                                    <a className="nav-link dropdown-toggle" href="#!" id="navbarDropdown" role="button"
                                       data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Blogs</a>

                                    <ul className="dropdown-menu" aria-labelledby="navbarDropdown">
                                        <li><a className="dropdown-item @@blog" href="blog.html">Blog</a></li>
                                        <li><a className="dropdown-item @@blogDetails" href="blog-details.html">Blog
                                            Details</a></li>
                                        <li className="dropdown dropdown-submenu dropright">
                                            <a className="dropdown-item dropdown-toggle" href="#!" id="navbarDropdown"
                                               role="button" data-toggle="dropdown" aria-haspopup="true"
                                               aria-expanded="false">Sub Menu</a>

                                            <ul className="dropdown-menu" aria-labelledby="navbarDropdown">
                                                <li><a className="dropdown-item" href="index.html">Submenu 01</a></li>
                                                <li><a className="dropdown-item" href="index.html">Submenu 02</a></li>
                                            </ul>
                                        </li>
                                    </ul>
                                </li>
                                <li className="nav-item @@contact">
                                    <a className="nav-link" href="contact.html">Contact</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </nav>
                <div className="hero-slider">
                    <div className={"slider-item slide1 "+classes.slide1A}>
                        <div className="container">
                            <div className="row">
                                <div className="col-12">
                                    <div className="content style text-center">
                                        <h2 className="text-white text-bold mb-2" data-animation-in="slideInLeft">Our
                                            Best Surgeons</h2>
                                        <p className="tag-text mb-4" data-animation-in="slideInRight">Lorem ipsum dolor
                                            sit amet consectetur adipisicing elit. Vel sunt animi sequi ratione quod at
                                            earum. <br/> Quis quos officiis numquam!</p>
                                        <a href="about.html" className="btn btn-main btn-white"
                                           data-animation-in="slideInLeft" data-duration-in="1.2">explore</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div className={"slider-item "+classes.slideItem1} >
                        <div className="container">
                            <div className="row">
                                <div className="col-12">
                                    <div className="content style text-center">
                                        <h2 className="text-white" data-animation-in="slideInRight">We Care About Your
                                            Health</h2>
                                        <p className="tag-text mb-4" data-animation-in="slideInRight"
                                           data-duration-in="0.6">Lorem ipsum dolor sit amet consectetur adipisicing
                                            elit. </p>
                                        <a href="about.html" className="btn btn-main btn-white"
                                           data-animation-in="slideInRight" data-duration-in="1.2">about us</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div className={"slider-item "+classes.slideItem2} >
                        <div className="container">
                            <div className="row">
                                <div className="col-12">
                                    <div className="content text-center style">
                                        <h2 className="text-white text-bold mb-2" data-animation-in="slideInRight">Best
                                            Medical Services</h2>
                                        <p className="tag-text mb-4" data-animation-in="slideInLeft">Lorem ipsum dolor
                                            sit amet consectetur adipisicing elit. Beatae deserunt, <br/>eius pariatur
                                                minus itaque nostrum.</p>
                                        <a href="about.html" className="btn btn-main btn-white"
                                           data-animation-in="slideInRight" data-duration-in="1.2">shop now</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <section className="cta">
                    <div className="container">
                        <div className="cta-block row no-gutters">
                            <div className="col-lg-4 col-md-6 emmergency item">
                                <i className="fa fa-phone"></i>
                                <h2>Emegency Cases</h2>
                                <a href="tel:1-800-700-6200">1-800-700-6200</a>
                                <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit.</p>
                            </div>
                            <div className="col-lg-4 col-md-6 top-doctor item">
                                <i className="fa fa-stethoscope"></i>
                                <h2>24 Hour Service</h2>
                                <p>Lorem ipsum dolor, sit amet consectetur adipisicing elit. Inventore dignissimos
                                    officia dicta suscipit
                                    vel eum</p>
                                <a href="service.html" className="btn btn-main">Read more</a>
                            </div>
                            <div className="col-lg-4 col-md-12 working-time item">
                                <i className="fa fa-hourglass-o"></i>
                                <h2>Working Hours</h2>
                                <ul className="w-hours">
                                    <li>Mon - Fri - <span>8:00 - 17:00</span></li>
                                    <li>Mon - Fri - <span>8:00 - 17:00</span></li>
                                    <li>Mon - Fri - <span>8:00 - 17:00</span></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </section>
                <section className="feature-section section bg-gray">
                    <div className="container">
                        <div className="row">
                            <div className="col-lg-12">
                                <div className="image-content">
                                    <div className="section-title text-center">
                                        <h3>Best Features <span>of Our Hospital</span></h3>
                                        <p className="mb-0">Lorem ipsum dolor sit amet consectetur adipisicing elit.
                                            Ipsam magni in at debitis <br/> nam error officia vero tempora alias? Sunt?
                                        </p>
                                    </div>

                                    <div className="row">
                                        <div className="col-sm-6">
                                            <div className="item">
                                                <div className="icon-box">
                                                    <figure>
                                                        <a href="services.html"><img loading="lazy"
                                                                                     src="images/resource/1.png"
                                                                                     alt="features image" /></a>
                                                    </figure>
                                                </div>
                                                <h3 className="mb-2">Orthopedics</h3>
                                                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Nihil
                                                    ducimus veniam illo quibusdam pariatur
                                                    ex sunt, est aspernatur
                                                    at debitis eius vitae vel nostrum dolorem labore autem corrupti odit
                                                    mollitia?</p>
                                            </div>
                                        </div>
                                        <div className="col-sm-6">
                                            <div className="item">
                                                <div className="icon-box">
                                                    <figure>
                                                        <a href="services.html">
                                                            <img loading="lazy" src="images/resource/2.png"
                                                                 alt="features image" />
                                                        </a>
                                                    </figure>
                                                </div>
                                                <h3 className="mb-2">Diaginostic</h3>
                                                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Nihil
                                                    ducimus veniam illo quibusdam pariatur
                                                    ex sunt, est aspernatur
                                                    at debitis eius vitae vel nostrum dolorem labore autem corrupti odit
                                                    mollitia?</p>
                                            </div>
                                        </div>
                                        <div className="col-sm-6">
                                            <div className="item">
                                                <div className="icon-box">
                                                    <figure>
                                                        <a href="services.html">
                                                            <img loading="lazy" src="images/resource/3.png"
                                                                 alt="features image" />
                                                        </a>
                                                    </figure>
                                                </div>
                                                <h3 className="mb-2">Psycology</h3>
                                                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Nihil
                                                    ducimus veniam illo quibusdam pariatur
                                                    ex sunt, est aspernatur
                                                    at debitis eius vitae vel nostrum dolorem labore autem corrupti odit
                                                    mollitia?</p>
                                            </div>
                                        </div>
                                        <div className="col-sm-6">
                                            <div className="item">
                                                <div className="icon-box">
                                                    <figure>
                                                        <a href="services.html">
                                                            <img loading="lazy" src="images/resource/4.png"
                                                                 alt="features image"/>
                                                        </a>
                                                    </figure>
                                                </div>
                                                <h3 className="mb-2">General Treatment</h3>
                                                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Nihil
                                                    ducimus veniam illo quibusdam pariatur
                                                    ex sunt, est aspernatur
                                                    at debitis eius vitae vel nostrum dolorem labore autem corrupti odit
                                                    mollitia?</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
                <section className="service-tab-section section">
                    <div className="outer-box clearfix">
                        <div className="container">
                            <div className="row">
                                <div className="col-md-12">
                                    <div className="tabs mb-5">
                                        <ul className="nav nav-tabs justify-content-center" id="aboutTab"
                                            role="tablist">
                                            <li className="nav-item" role="presentation">
                                                <a className="nav-link active" id="dormitory-tab" data-toggle="tab"
                                                   href="#dormitory" role="tab" aria-controls="dormitory"
                                                   aria-selected="true">dormitory</a>
                                            </li>
                                            <li className="nav-item" role="presentation">
                                                <a className="nav-link" id="orthopedic-tab" data-toggle="tab"
                                                   href="#orthopedic" role="tab" aria-controls="orthopedic"
                                                   aria-selected="false">orthopedic</a>
                                            </li>
                                            <li className="nav-item" role="presentation">
                                                <a className="nav-link" id="sonogram-tab" data-toggle="tab"
                                                   href="#sonogram" role="tab" aria-controls="sonogram"
                                                   aria-selected="false">sonogram</a>
                                            </li>
                                            <li className="nav-item" role="presentation">
                                                <a className="nav-link" id="x-ray-tab" data-toggle="tab" href="#x-ray"
                                                   role="tab" aria-controls="x-ray" aria-selected="false">x-ray</a>
                                            </li>
                                            <li className="nav-item" role="presentation">
                                                <a className="nav-link" id="diagnostic-tab" data-toggle="tab"
                                                   href="#diagnostic" role="tab" aria-controls="diagnostic"
                                                   aria-selected="false">diagnostic</a>
                                            </li>
                                        </ul>
                                    </div>
                                    <div className="tab-content" id="aboutTab">
                                        <div className="service-box tab-pane fade show active" id="dormitory">
                                            <div className="row">
                                                <div className="col-lg-6">
                                                    <img loading="lazy" className="img-fluid"
                                                         src="images/services/service-one.jpg" alt="service-image"/>
                                                </div>
                                                <div className="col-lg-6">
                                                    <div className="contents">
                                                        <div className="section-title">
                                                            <h3>dormitory</h3>
                                                        </div>
                                                        <div className="text">
                                                            <p>The implant fixture is first placed, so that it ilikely
                                                                to osseointegrate,
                                                                then a dental prosthetic is added. then a
                                                                dental prosthetic is added.then a dental pros- thetic is
                                                                added.</p>
                                                            <p>The implant fixture is first placed, so that it ilikely
                                                                to osseointegrate,
                                                                then a dental prosthetic is added. then a dental
                                                                prosthetic is added.then a dental pros- thetic is
                                                                added.</p>
                                                        </div>
                                                        <ul className="content-list">
                                                            <li>
                                                                <i className="far fa-dot-circle"></i>Whitening is among
                                                                the most popular dental
                                                            </li>
                                                            <li>
                                                                <i className="far fa-dot-circle"></i>Teeth cleaning is
                                                                part of oral hygiene and
                                                                involves
                                                            </li>
                                                            <li>
                                                                <i className="far fa-dot-circle"></i>Teeth cleaning is
                                                                part of oral hygiene and
                                                                involves
                                                            </li>
                                                        </ul>
                                                        <a href="services.html" className="btn btn-style-one">Read
                                                            more</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div className="service-box tab-pane fade" id="orthopedic">
                                            <div className="row">
                                                <div className="col-lg-6">
                                                    <img loading="lazy" className="img-fluid"
                                                         src="images/services/service-two.jpg" alt="service-image"/>
                                                </div>
                                                <div className="col-lg-6">
                                                    <div className="contents">
                                                        <div className="section-title">
                                                            <h3>orthopedic</h3>
                                                        </div>
                                                        <div className="text">
                                                            <p>The implant fixture is first placed, so that it ilikely
                                                                to osseointegrate,
                                                                then a dental prosthetic is added.
                                                                then a dental prosthetic is added.then a dental pros-
                                                                thetic is added.</p>
                                                            <p>The implant fixture is first placed, so that it ilikely
                                                                to osseointegrate,
                                                                then a dental prosthetic is added.
                                                                then a dental prosthetic is added.then a dental pros-
                                                                thetic is added.</p>
                                                        </div>
                                                        <ul className="content-list">
                                                            <li>
                                                                <i className="far fa-dot-circle"></i>Whitening is among
                                                                the most popular dental
                                                            </li>
                                                            <li>
                                                                <i className="far fa-dot-circle"></i>Teeth cleaning is
                                                                part of oral hygiene and
                                                                involves
                                                            </li>
                                                            <li>
                                                                <i className="far fa-dot-circle"></i>Teeth cleaning is
                                                                part of oral hygiene and
                                                                involves
                                                            </li>
                                                        </ul>
                                                        <a href="services.html" className="btn btn-style-one">Read
                                                            more</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div className="service-box tab-pane fade" id="sonogram">
                                            <div className="row">
                                                <div className="col-lg-6">
                                                    <img loading="lazy" className="img-fluid"
                                                         src="images/services/service-three.jpg" alt="service-image"/>
                                                </div>
                                                <div className="col-lg-6">
                                                    <div className="contents">
                                                        <div className="section-title">
                                                            <h3>sonogram</h3>
                                                        </div>
                                                        <div className="text">
                                                            <p>The implant fixture is first placed, so that it ilikely
                                                                to osseointegrate,
                                                                then a dental prosthetic is added.
                                                                then a dental prosthetic is added.then a dental pros-
                                                                thetic is added.</p>
                                                            <p>The implant fixture is first placed, so that it ilikely
                                                                to osseointegrate,
                                                                then a dental prosthetic is added.
                                                                then a dental prosthetic is added.then a dental pros-
                                                                thetic is added.</p>
                                                        </div>
                                                        <ul className="content-list">
                                                            <li>
                                                                <i className="far fa-dot-circle"></i>Whitening is among
                                                                the most popular dental
                                                            </li>
                                                            <li>
                                                                <i className="far fa-dot-circle"></i>Teeth cleaning is
                                                                part of oral hygiene and
                                                                involves
                                                            </li>
                                                            <li>
                                                                <i className="far fa-dot-circle"></i>Teeth cleaning is
                                                                part of oral hygiene and
                                                                involves
                                                            </li>
                                                        </ul>
                                                        <a href="services.html" className="btn btn-style-one">Read
                                                            more</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div className="service-box tab-pane fade" id="x-ray">
                                            <div className="row">
                                                <div className="col-lg-6">
                                                    <img loading="lazy" className="img-fluid"
                                                         src="images/services/service-four.jpg" alt="service-image"/>
                                                </div>
                                                <div className="col-lg-6">
                                                    <div className="contents">
                                                        <div className="section-title">
                                                            <h3>x-ray</h3>
                                                        </div>
                                                        <div className="text">
                                                            <p>The implant fixture is first placed, so that it ilikely
                                                                to osseointegrate,
                                                                then a dental prosthetic is added.
                                                                then a dental prosthetic is added.then a dental pros-
                                                                thetic is added.</p>
                                                            <p>The implant fixture is first placed, so that it ilikely
                                                                to osseointegrate,
                                                                then a dental prosthetic is added.
                                                                then a dental prosthetic is added.then a dental pros-
                                                                thetic is added.</p>
                                                        </div>
                                                        <ul className="content-list">
                                                            <li>
                                                                <i className="far fa-dot-circle"></i>Whitening is among
                                                                the most popular dental
                                                            </li>
                                                            <li>
                                                                <i className="far fa-dot-circle"></i>Teeth cleaning is
                                                                part of oral hygiene and
                                                                involves
                                                            </li>
                                                            <li>
                                                                <i className="far fa-dot-circle"></i>Teeth cleaning is
                                                                part of oral hygiene and
                                                                involves
                                                            </li>
                                                        </ul>
                                                        <a href="services.html" className="btn btn-style-one">Read
                                                            more</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div className="service-box tab-pane fade" id="diagnostic">
                                            <div className="row">
                                                <div className="col-lg-6">
                                                    <img loading="lazy" className="img-fluid"
                                                         src="images/services/service-five.jpg" alt="service-image"/>
                                                </div>
                                                <div className="col-lg-6">
                                                    <div className="contents">
                                                        <div className="section-title">
                                                            <h3>diagnostic</h3>
                                                        </div>
                                                        <div className="text">
                                                            <p>The implant fixture is first placed, so that it ilikely
                                                                to osseointegrate,
                                                                then a dental prosthetic is added.
                                                                then a dental prosthetic is added.then a dental pros-
                                                                thetic is added.</p>
                                                            <p>The implant fixture is first placed, so that it ilikely
                                                                to osseointegrate,
                                                                then a dental prosthetic is added.
                                                                then a dental prosthetic is added.then a dental pros-
                                                                thetic is added.</p>
                                                        </div>
                                                        <ul className="content-list">
                                                            <li>
                                                                <i className="far fa-dot-circle"></i>Whitening is among
                                                                the most popular dental
                                                            </li>
                                                            <li>
                                                                <i className="far fa-dot-circle"></i>Teeth cleaning is
                                                                part of oral hygiene and
                                                                involves
                                                            </li>
                                                            <li>
                                                                <i className="far fa-dot-circle"></i>Teeth cleaning is
                                                                part of oral hygiene and
                                                                involves
                                                            </li>
                                                        </ul>
                                                        <a href="services.html" className="btn btn-style-one">Read
                                                            more</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
                <section className="service-section bg-gray section">
                    <div className="container">
                        <div className="section-title text-center">
                            <h3>Provided
                                <span>Services</span>
                            </h3>
                            <p>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Lorem ipsum dolor sit amet. qui
                                suscipit atque <br/>
                                    fugiat officia corporis rerum eaque neque totam animi, sapiente culpa. Architecto!
                            </p>
                        </div>
                        <div className="row">
                            <div className="col-lg-12">
                                <div className="items-container">
                                    <div className="item">
                                        <div className="inner-box">
                                            <div className="img_holder">
                                                <a href="service.html">
                                                    <img loading="lazy" src="images/gallery/1.jpg" alt="images"
                                                         className="img-fluid"/>
                                                </a>
                                            </div>
                                            <div className="image-content text-center">
                                                <span>Better Service At Low Cost</span>
                                                <a href="service.html">
                                                    <h6>Dormitory</h6>
                                                </a>
                                                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Suscipit,
                                                    vero.</p>
                                            </div>
                                        </div>
                                    </div>
                                    <div className="item">
                                        <div className="inner-box">
                                            <div className="img_holder">
                                                <a href="service.html">
                                                    <img loading="lazy" src="images/gallery/2.jpg" alt="images"
                                                         className="img-fluid"/>
                                                </a>
                                            </div>
                                            <div className="image-content text-center">
                                                <span>Better Service At Low Cost</span>
                                                <a href="service.html">
                                                    <h6>Germs Protection</h6>
                                                </a>
                                                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Suscipit,
                                                    vero.</p>
                                            </div>
                                        </div>
                                    </div>
                                    <div className="item">
                                        <div className="inner-box">
                                            <div className="img_holder">
                                                <a href="service.html">
                                                    <img loading="lazy" src="images/gallery/3.jpg" alt="images"
                                                         className="img-fluid"/>
                                                </a>
                                            </div>
                                            <div className="image-content text-center">
                                                <span>Better Service At Low Cost</span>
                                                <a href="service.html">
                                                    <h6>Psycology</h6>
                                                </a>
                                                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Suscipit,
                                                    vero.</p>
                                            </div>
                                        </div>
                                    </div>
                                    <div className="item">
                                        <div className="inner-box">
                                            <div className="img_holder">
                                                <a href="service.html">
                                                    <img loading="lazy" src="images/gallery/1.jpg" alt="images"
                                                         className="img-fluid"/>
                                                </a>
                                            </div>
                                            <div className="image-content text-center">
                                                <span>Better Service At Low Cost</span>
                                                <a href="service.html">
                                                    <h6>Dormitory</h6>
                                                </a>
                                                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Suscipit,
                                                    vero.</p>
                                            </div>
                                        </div>
                                    </div>
                                    <div className="item">
                                        <div className="inner-box">
                                            <div className="img_holder">
                                                <a href="service.html">
                                                    <img loading="lazy" src="images/gallery/2.jpg" alt="images"
                                                         className="img-fluid"/>
                                                </a>
                                            </div>
                                            <div className="image-content text-center">
                                                <span>Better Service At Low Cost</span>
                                                <a href="service.html">
                                                    <h6>Germs Protection</h6>
                                                </a>
                                                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Suscipit,
                                                    vero.</p>
                                            </div>
                                        </div>
                                    </div>
                                    <div className="item">
                                        <div className="inner-box">
                                            <div className="img_holder">
                                                <a href="service.html">
                                                    <img loading="lazy" src="images/gallery/3.jpg" alt="images"
                                                         className="img-fluid"/>
                                                </a>
                                            </div>
                                            <div className="image-content text-center">
                                                <span>Better Service At Low Cost</span>
                                                <a href="service.html">
                                                    <h6>Psycology</h6>
                                                </a>
                                                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Suscipit,
                                                    vero.</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
                <section className="team-section section">
                    <div className="container">
                        <div className="section-title text-center">
                            <h3>Our Expert
                                <span>Doctors</span>
                            </h3>
                            <p className="mb-0">Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptatem
                                illo, rerum
                                <br/>natus nobis deleniti doloremque minima odit voluptatibus ipsam animi?</p>
                        </div>
                        <div className="row justify-content-center">
                            <div className="col-lg-4 col-md-6">
                                <div className="team-member">
                                    <img loading="lazy" src="images/team/doctor-2.jpg" alt="doctor"
                                         className="img-fluid"/>
                                        <div className="contents text-center">
                                            <h4>Dr. Robert Barrethion</h4>
                                            <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Dignissimos,
                                                aspernatur.</p>
                                            <a href="appointment.html" className="btn btn-main">Book Appointment</a>
                                        </div>
                                </div>
                            </div>
                            <div className="col-lg-4 col-md-6">
                                <div className="team-member">
                                    <img loading="lazy" src="images/team/doctor-lab-3.jpg" alt="doctor"
                                         className="img-fluid"/>
                                        <div className="contents text-center">
                                            <h4>Dr. Marry Lou</h4>
                                            <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Dignissimos,
                                                aspernatur.</p>
                                            <a href="appointment.html" className="btn btn-main">Book Appointment</a>
                                        </div>
                                </div>
                            </div>
                            <div className="col-lg-4 col-md-6">
                                <div className="team-member">
                                    <img loading="lazy" src="images/team/event-2.jpg" alt="doctor"
                                         className="img-fluid"/>
                                        <div className="contents text-center">
                                            <h4>Dr. Sansa Stark</h4>
                                            <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Dignissimos,
                                                aspernatur.</p>
                                            <a href="appointment.html" className="btn btn-main">Book Appointment</a>
                                        </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
                <section className={"testimonial-section "+classes.testimonialSection}>
                    <div className="container">
                        <div className="row">
                            <div className="col-lg-12">
                                <div className="section-title text-center">
                                    <h3>What Our
                                        <span>Patients Says</span>
                                    </h3>
                                </div>
                            </div>
                        </div>
                        <div className="row">
                            <div className="col-lg-12">
                                <div className="testimonial-carousel">
                                    <div className="slide-item">
                                        <div className="inner-box text-center">
                                            <div className="image-box">
                                                <figure>
                                                    <img loading="lazy" src="images/testimonials/1.png" alt=""/>
                                                </figure>
                                            </div>
                                            <h6>Adam Rose</h6>
                                            <p className="mb-0">Neque porro quisquam est, qui dolorem ipsum quia
                                                consectetur, dolor sit amet, consectetur, numquam Lorem
                                                ipsum dolor sit amet consectetur adipisicing elit. Molestias, at?</p>
                                        </div>
                                    </div>
                                    <div className="slide-item">
                                        <div className="inner-box text-center">
                                            <div className="image-box">
                                                <figure>
                                                    <img loading="lazy" src="images/testimonials/2.png" alt=""/>
                                                </figure>
                                            </div>
                                            <h6>David Warner</h6>
                                            <p className="mb-0">Neque porro quisquam est, qui dolorem ipsum quia
                                                consectetur, dolor sit amet, consectetur, numquam Lorem
                                                ipsum dolor sit amet consectetur adipisicing elit. Molestias, at?</p>
                                        </div>
                                    </div>
                                    <div className="slide-item">
                                        <div className="inner-box text-center">
                                            <div className="image-box">
                                                <figure>
                                                    <img loading="lazy" src="images/testimonials/3.png" alt=""/>
                                                </figure>
                                            </div>
                                            <h6>Amy Adams</h6>
                                            <p className="mb-0">Neque porro quisquam est, qui dolorem ipsum quia
                                                consectetur, dolor sit amet, consectetur, numquam Lorem
                                                ipsum dolor sit amet consectetur adipisicing elit. Molestias, at?</p>
                                        </div>
                                    </div>
                                    <div className="slide-item">
                                        <div className="inner-box text-center">
                                            <div className="image-box">
                                                <figure>
                                                    <img loading="lazy" src="images/testimonials/1.png" alt=""/>
                                                </figure>
                                            </div>
                                            <h6>Adam Rose</h6>
                                            <p className="mb-0">Neque porro quisquam est, qui dolorem ipsum quia
                                                consectetur, dolor sit amet, consectetur, numquam Lorem
                                                ipsum dolor sit amet consectetur adipisicing elit. Molestias, at?</p>
                                        </div>
                                    </div>
                                    <div className="slide-item">
                                        <div className="inner-box text-center">
                                            <div className="image-box">
                                                <figure>
                                                    <img loading="lazy" src="images/testimonials/2.png" alt=""/>
                                                </figure>
                                            </div>
                                            <h6>David Warner</h6>
                                            <p className="mb-0">Neque porro quisquam est, qui dolorem ipsum quia
                                                consectetur, dolor sit amet, consectetur, numquam Lorem
                                                ipsum dolor sit amet consectetur adipisicing elit. Molestias, at?</p>
                                        </div>
                                    </div>
                                    <div className="slide-item">
                                        <div className="inner-box text-center">
                                            <div className="image-box">
                                                <figure>
                                                    <img loading="lazy" src="images/testimonials/3.png" alt=""/>
                                                </figure>
                                            </div>
                                            <h6>Amy Adams</h6>
                                            <p className="mb-0">Neque porro quisquam est, qui dolorem ipsum quia
                                                consectetur, dolor sit amet, consectetur, numquam Lorem
                                                ipsum dolor sit amet consectetur adipisicing elit. Molestias, at?</p>
                                        </div>
                                    </div>
                                    <div className="slide-item">
                                        <div className="inner-box text-center">
                                            <div className="image-box">
                                                <figure>
                                                    <img loading="lazy" src="images/testimonials/1.png" alt=""/>
                                                </figure>
                                            </div>
                                            <h6>Adam Rose</h6>
                                            <p className="mb-0">Neque porro quisquam est, qui dolorem ipsum quia
                                                consectetur, dolor sit amet, consectetur, numquam Lorem
                                                ipsum dolor sit amet consectetur adipisicing elit. Molestias, at?</p>
                                        </div>
                                    </div>
                                    <div className="slide-item">
                                        <div className="inner-box text-center">
                                            <div className="image-box">
                                                <figure>
                                                    <img loading="lazy" src="images/testimonials/2.png" alt=""/>
                                                </figure>
                                            </div>
                                            <h6>David Warner</h6>
                                            <p className="mb-0">Neque porro quisquam est, qui dolorem ipsum quia
                                                consectetur, dolor sit amet, consectetur, numquam Lorem
                                                ipsum dolor sit amet consectetur adipisicing elit. Molestias, at?</p>
                                        </div>
                                    </div>
                                    <div className="slide-item">
                                        <div className="inner-box text-center">
                                            <div className="image-box">
                                                <figure>
                                                    <img loading="lazy" src="images/testimonials/3.png" alt=""/>
                                                </figure>
                                            </div>
                                            <h6>Amy Adams</h6>
                                            <p className="mb-0">Neque porro quisquam est, qui dolorem ipsum quia
                                                consectetur, dolor sit amet, consectetur, numquam Lorem
                                                ipsum dolor sit amet consectetur adipisicing elit. Molestias, at?</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
                <section className="appoinment-section section">
                    <div className="container">
                        <div className="row">
                            <div className="col-lg-6">
                                <div className="accordion-section">
                                    <div className="section-title">
                                        <h3>FAQ</h3>
                                    </div>
                                    <div className="accordion-holder">
                                        <div className="accordion" id="accordionGroup" role="tablist"
                                             aria-multiselectable="true">
                                            <div className="card">
                                                <div className="card-header" role="tab" id="headingOne">
                                                    <h4 className="card-title">
                                                        <a role="button" data-toggle="collapse" href="#collapseOne"
                                                           aria-expanded="true" aria-controls="collapseOne">
                                                            Why Should I choose Medical Health
                                                        </a>
                                                    </h4>
                                                </div>
                                                <div id="collapseOne" className="collapse show" role="tabpanel"
                                                     aria-labelledby="headingOne" data-parent="#accordionGroup">
                                                    <div className="card-body">
                                                        Anim pariatur cliche reprehenderit, enim eiusmod high life
                                                        accusamus terry richardson ad squid. 3 wolf moon
                                                        officia aute,
                                                        non cupidatat skateboard dolor brunch. Food truck quinoa
                                                        nesciunt laborum eiusmod. Brunch 3 wolf moon
                                                        tempor,
                                                        sunt aliqua put a bird on it squid single-origin coffee nulla
                                                        assumenda shoreditch et. Nihil anim keffiyeh
                                                        helvetica, craft beer labore wes anderson cred nesciunt sapiente
                                                        ea proident. Ad vegan excepteur butcher
                                                        vice lomo. Leggings occaecat craft beer farm-to-table, raw denim
                                                        aesthetic synth nesciunt you probably
                                                        haven't
                                                        heard of them accusamus labore sustainable VHS.
                                                    </div>
                                                </div>
                                            </div>
                                            <div className="card">
                                                <div className="card-header" role="tab" id="headingTwo">
                                                    <h4 className="card-title">
                                                        <a className="collapsed" role="button" data-toggle="collapse"
                                                           href="#collapseTwo"
                                                           aria-expanded="false" aria-controls="collapseTwo">
                                                            What are the Centre’s visiting hours?
                                                        </a>
                                                    </h4>
                                                </div>
                                                <div id="collapseTwo" className="collapse" role="tabpanel"
                                                     aria-labelledby="headingTwo" data-parent="#accordionGroup">
                                                    <div className="card-body">
                                                        Anim pariatur cliche reprehenderit, enim eiusmod high life
                                                        accusamus terry richardson ad squid. 3 wolf moon
                                                        officia aute,
                                                        non cupidatat skateboard dolor brunch. Food truck quinoa
                                                        nesciunt laborum eiusmod. Brunch 3 wolf moon
                                                        tempor,
                                                        sunt aliqua put a bird on it squid single-origin coffee nulla
                                                        assumenda shoreditch et. Nihil anim keffiyeh
                                                        helvetica, craft beer labore wes anderson cred nesciunt sapiente
                                                        ea proident. Ad vegan excepteur butcher
                                                        vice lomo. Leggings occaecat craft beer farm-to-table, raw denim
                                                        aesthetic synth nesciunt you probably
                                                        haven't
                                                        heard of them accusamus labore sustainable VHS.
                                                    </div>
                                                </div>
                                            </div>
                                            <div className="card">
                                                <div className="card-header" role="tab" id="headingThree">
                                                    <h4 className="card-title">
                                                        <a className="collapsed" role="button" data-toggle="collapse"
                                                           href="#collapseThree"
                                                           aria-expanded="false" aria-controls="collapseThree">
                                                            How many visitors are allowed?
                                                        </a>
                                                    </h4>
                                                </div>
                                                <div id="collapseThree" className="collapse" role="tabpanel"
                                                     aria-labelledby="headingThree" data-parent="#accordionGroup">
                                                    <div className="card-body">
                                                        Anim pariatur cliche reprehenderit, enim eiusmod high life
                                                        accusamus terry richardson ad squid. 3 wolf moon
                                                        officia aute,
                                                        non cupidatat skateboard dolor brunch. Food truck quinoa
                                                        nesciunt laborum eiusmod. Brunch 3 wolf moon
                                                        tempor,
                                                        sunt aliqua put a bird on it squid single-origin coffee nulla
                                                        assumenda shoreditch et. Nihil anim keffiyeh
                                                        helvetica, craft beer labore wes anderson cred nesciunt sapiente
                                                        ea proident. Ad vegan excepteur butcher
                                                        vice lomo. Leggings occaecat craft beer farm-to-table, raw denim
                                                        aesthetic synth nesciunt you probably
                                                        haven't
                                                        heard of them accusamus labore sustainable VHS.
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div className="col-lg-6">
                                <div className="contact-area pl-0 pl-lg-5">
                                    <div className="section-title">
                                        <h3>Request
                                            <span>Appointment</span>
                                        </h3>
                                    </div>
                                    <form name="contact_form" className="default-form contact-form" action="!#"
                                          method="post">
                                        <div className="row">
                                            <div className="col-md-6">
                                                <div className="form-group">
                                                    <input className="form-control" type="text" name="Name"
                                                           placeholder="Name" required=""/>
                                                </div>
                                                <div className="form-group">
                                                    <input className="form-control" type="email" name="Email"
                                                           placeholder="Email" required=""/>
                                                </div>
                                                <div className="form-group">
                                                    <select className="form-control" name="subject">
                                                        <option>Departments</option>
                                                        <option>Diagnostic</option>
                                                        <option>Psychological</option>
                                                    </select>
                                                </div>
                                            </div>
                                            <div className="col-md-6">
                                                <div className="form-group">
                                                    <input className="form-control" type="text" name="Phone"
                                                           placeholder="Phone" required=""/>
                                                </div>
                                                <div className="form-group">
                                                    <input className="form-control" type="text" name="Date"
                                                           placeholder="Date" required="" id="datepicker"
                                                           autoComplete="off"/>
                                                        <i className="fa fa-calendar" aria-hidden="true"></i>
                                                </div>
                                                <div className="form-group">
                                                    <select className="form-control" name="subject">
                                                        <option>Doctor</option>
                                                        <option>Diagnostic</option>
                                                        <option>Psychological</option>
                                                    </select>
                                                </div>
                                            </div>
                                            <div className="col-md-12">
                                                <div className="form-group">
                                                    <textarea className="form-control" name="form_message"
                                                              placeholder="Your Message" required=""></textarea>
                                                </div>
                                                <div className="form-group text-center">
                                                    <button type="submit" className="btn-style-one">submit now</button>
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
                <footer className="footer-main">
                    <div className="footer-top">
                        <div className="container">
                            <div className="row justify-content-between">
                                <div className="col-lg-4 mb-5 mb-lg-0">
                                    <div className="about-widget">
                                        <div className="footer-logo">
                                            <figure>
                                                <a href="index.html">
                                                    <img loading="lazy" className="img-fluid" src="images/logo-2.png"
                                                         alt="medic"/>
                                                </a>
                                            </figure>
                                        </div>
                                        <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Molestias,
                                            temporibus?</p>
                                        <ul className="location-link">
                                            <li className="item">
                                                <i className="fas fa-map-marker-alt"></i>
                                                <p>Modamba, NY 80021, United States</p>
                                            </li>
                                            <li className="item">
                                                <i className="far fa-envelope" aria-hidden="true"></i>
                                                <a href="mailto:support@medic.com">
                                                    <p>support@medic.com</p>
                                                </a>
                                            </li>
                                            <li className="item">
                                                <i className="fas fa-phone" aria-hidden="true"></i>
                                                <p>(88017) +123 4567</p>
                                            </li>
                                        </ul>
                                        <ul className="list-inline social-icons">
                                            <li className="list-inline-item"><a href="https://facebook.com/themefisher"
                                                                                aria-label="facebook"><i
                                                className="fab fa-facebook-f"></i></a></li>
                                            <li className="list-inline-item"><a href="https://twitter.com/themefisher"
                                                                                aria-label="twitter"><i
                                                className="fab fa-twitter"></i></a></li>
                                            <li className="list-inline-item"><a href="https://instagram.com/themefisher"
                                                                                aria-label="instagram"><i
                                                className="fab fa-instagram"></i></a></li>
                                            <li className="list-inline-item"><a href="https://github.com/themefisher"
                                                                                aria-label="github"><i
                                                className="fab fa-github"></i></a></li>
                                        </ul>
                                    </div>
                                </div>
                                <div className="col-lg-3 col-md-5 mb-3 mb-md-0">
                                    <h2>Services</h2>
                                    <ul className="menu-link">
                                        <li>
                                            <a href="service.html">
                                                <i className="fa fa-angle-right" aria-hidden="true"></i>Orthopadic
                                                Liabilities</a>
                                        </li>
                                        <li>
                                            <a href="service.html">
                                                <i className="fa fa-angle-right" aria-hidden="true"></i>Dental
                                                Clinic</a>
                                        </li>
                                        <li>
                                            <a href="service.html">
                                                <i className="fa fa-angle-right" aria-hidden="true"></i>Dormamu
                                                Clinic</a>
                                        </li>
                                        <li>
                                            <a href="service.html">
                                                <i className="fa fa-angle-right" aria-hidden="true"></i>Psycological
                                                Clinic</a>
                                        </li>
                                        <li>
                                            <a href="service.html">
                                                <i className="fa fa-angle-right" aria-hidden="true"></i>Gynaecological
                                                Clinic</a>
                                        </li>
                                    </ul>
                                </div>
                                <div className="col-lg-4 col-md-7">
                                    <div className="social-links">
                                        <h2>Recent Posts</h2>
                                        <ul>
                                            <li className="item">
                                                <div className="media">
                                                    <div className="media-left mr-3">
                                                        <a href="blog-details.html">
                                                            <img loading="lazy" src="images/blog/post-thumb-small.jpg"
                                                                 alt="post-thumb"/>
                                                        </a>
                                                    </div>
                                                    <div className="media-body">
                                                        <h5><a href="blog-details.html">A lesson adip isicing</a></h5>
                                                        <p>Lorem ipsum dolor sit amet consectetur adipisicing elit.
                                                            Aperiam, dolorem.</p>
                                                    </div>
                                                </div>
                                            </li>
                                            <li className="item">
                                                <div className="media">
                                                    <div className="media-left mr-3">
                                                        <a href="blog-details.html">
                                                            <img loading="lazy" src="images/blog/post-thumb-small.jpg"
                                                                 alt="post-thumb"/>
                                                        </a>
                                                    </div>
                                                    <div className="media-body">
                                                        <h5><a href="blog-details.html">How to make an event</a></h5>
                                                        <p>Lorem ipsum dolor sit amet consectetur adipisicing elit.
                                                            Aperiam, dolorem.</p>
                                                    </div>
                                                </div>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div className="footer-bottom">
                        <div className="container clearfix">
                            <div className="copyright-text">
                                <p>&copy; Copyright 2021. Designed &amp; Developed by <a
                                    href="https://themefisher.com/">Themefisher</a></p>
                            </div>
                            <ul className="footer-bottom-link">
                                <li>
                                    <a href="index.html">Home</a>
                                </li>
                                <li>
                                    <a href="about.html">About</a>
                                </li>
                                <li>
                                    <a href="contact.html">Contact</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </footer>
                <div id="back-to-top" className="back-to-top">
                    <i className="fa fa-angle-up"></i>
                </div>

            </div>
            <div className="scroll-to-top scroll-to-target" data-target=".header-top">
                <span className="icon fa fa-angle-up"></span>
            </div>


        </div>
    )
}