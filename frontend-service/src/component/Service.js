import React, { useState } from 'react'
import { Button, Modal } from 'react-bootstrap'
import Asisten from './Asisten'

import Predict2 from './Predict2'


const Service = () => {
    const [show, setShow] = useState(false)
    const [show1, setShow1] = useState(false)
    const handleShow1 = () => setShow(true);
    const handleShow2 = () => setShow1(true);
    const handleClose = () => setShow(false);
    const handleClose1 = () => setShow1(false);
  return (
    <section class="page-section bg-light" id="services">
        
            <div class="container">
                <div class="text-center">
                    <h2 class="section-heading text-uppercase">Layanan</h2>
                    <br/>
                    <h4 class="section-subheading text-muted">Kami memliki layanan berupa alat prediksi penyakit tanaman padi dan asisten pertanian yang dapat membantu kegiatan pertanian para petani</h4>
                </div>
                          
                <div class="row text-center">
                    <div class="col-md-6" style={{padding: '20px'}}>
                            <div class="icon-fluid">
                                <span class="fa-stack fa-4x">
                                    <i class="fas fa-circle fa-stack-2x text-primary"></i>
                                    <i class="fas fa-magnifying-glass fa-stack-1x fa-inverse"></i>
                                </span>
                            </div>        
                        <button class="btn btn-secondary mt-4 mb-3" onClick={handleShow1}  >
                        <h4 class="my-1" style={{color: 'black'}}>Prediksi Penyakit!</h4>
                        </button>                                        
                        
                        <p class="text-muted">Petani dapat dengan mudah untuk memprediksi penyakit pada tanaman padi hanya dengan mengupload gambar tanaman yang ingin diprediksi! </p>
                    </div>
                    <div class="col-md-6" style={{padding: '20px'}}>
                            <div class="icon-fluid">
                                <span class="fa-stack fa-4x">
                                    <i class="fas fa-circle fa-stack-2x text-primary"></i>
                                    <i class="fas fa-handshake-angle fa-stack-1x fa-inverse"></i>
                                </span>
                            </div>        
                        <button class="btn btn-secondary mt-4 mb-3" onClick={handleShow2} >
                        <h4 class="my-1" style={{color: 'black'}}>Schedule!</h4>
                        </button>                                        
                        
                        <p class="text-muted">Program ini dapat membantu petani untuk membantu mengukur keberhasilan kegiatan pertanian yang dilakukan!</p>
                    </div>
                    
                    
                </div>
            </div>
            <Modal show={show} onHide={handleClose}
            size="lg"
            aria-labelledby="contained-modal-title-vcenter"
            centered>
                <Modal.Header closeButton>
                    <Modal.Title>Periksa Tanamanmu!</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    <Predict2/>
                </Modal.Body>
                <Modal.Footer>
                    <Button variant='primary' onClick={handleClose}>Tutup</Button>

                </Modal.Footer>

            </Modal>
            <Modal show={show1} onHide={handleClose1}
            size="lg"
            aria-labelledby="contained-modal-title-vcenter"
            centered>
                <Modal.Header closeButton>
                    <Modal.Title>Schedule!</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    <Asisten/>
                </Modal.Body>
                <Modal.Footer>
                    <Button variant='primary' onClick={handleClose}>Tutup</Button>

                </Modal.Footer>

            </Modal>
        </section>
        

       
        
  )
}

export default Service