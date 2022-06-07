import React from 'react'
import { Container } from 'react-bootstrap'

const Header = () => {
  return (
    <header class="masthead" id='home'>
            <Container>
                <div class="masthead-subheading">Welcome To Richest</div>
                <div class="masthead-heading text-uppercase">It's Nice To Meet You</div>
                <a class="btn btn-primary btn-xl text-uppercase" href="#services" style={{padding: '15px'}}>Start Your Journey !</a>
            </Container>
    </header>
  )
}

export default Header