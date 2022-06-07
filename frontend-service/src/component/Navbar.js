import React from 'react'
import { Nav, Navbar, Container } from 'react-bootstrap'
import Logo from "./../logo.png";

const navbar = () => {
  return (
    <Navbar bg='primary' variant="dark" expand="lg" fixed="top" >
  <Container>
    <Navbar.Brand href="#home"><img src={Logo} style={{width: '28px', height: 'px', paddingRight: '8px'}} alt=""/><strong>Richest</strong></Navbar.Brand>
    <Navbar.Toggle aria-controls="basic-navbar-nav" />
    <Navbar.Collapse id="basic-navbar-nav">
      <Nav className="me-auto">
        <Nav.Link href="#services">Layanan</Nav.Link>
        <Nav.Link href="#about">Tentang Kami</Nav.Link>
        <Nav.Link href="#team">Team</Nav.Link>
      </Nav>
    </Navbar.Collapse>
  </Container>
</Navbar>
  )
}

export default navbar