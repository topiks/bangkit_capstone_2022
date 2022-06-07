import React from 'react'
import { Card, Row, Col } from 'react-bootstrap'


const Asisten = () => {
  return (
    <>
    <Row xs={1}  className="g-4">
        
        <Col>
        <Card>
                <Card border="primary" >
                    <Card.Header>Penjelasan</Card.Header>
                        <Card.Body>
                            <Card.Text>
                            Layanan ini hanya tersedia pada aplikasi mobile kami. Aplikasi ini dapat membantu kegiatan para petani dalam mengorganisir kegiatan pertaniannya setiap hari. Setiap hari petani dapat menuliskan kegiatan apa yang dilakukan melalui kalendar yang tersedia seperti diary.
                            </Card.Text>
                        </Card.Body>
                </Card>
                <br/>
                <Card border="primary">
                    <Card.Header>Cara penggunaan</Card.Header>
                        <Card.Body>
                            <Card.Text>
                            Cara penggunaan layanan ini sederhana, pengguna hanya perlu login, dan memasukkan data sawah serta tanggal mulai kegiatan pertanian. Untuk dapat menikmati layanan ini silahkan download aplikasi mobile "Richest"
                            </Card.Text>
                        </Card.Body>
                </Card>
                <br/>
                





            </Card>
        </Col>
    </Row>
    </>
  )
}

export default Asisten