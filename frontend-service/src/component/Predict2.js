import React, { Component } from 'react';
import { post } from 'axios';
import recommendations from './Labels';
import { Card, Row, Col } from 'react-bootstrap';


class Predict2 extends Component {
    
  constructor(props) {
    super(props);
    this.state ={
        status: '',
        model:'',
        disease: '',
        prediction: '',
        previewimg:'',
    }
    this.onFormSubmit = this.onFormSubmit.bind(this)
    this.onChange = this.onChange.bind(this)
    this.fileUpload = this.fileUpload.bind(this)
    
  }

  onFormSubmit(e){
    e.preventDefault() 
    this.fileUpload(this.state.file).then((response)=>{
      console.log(response.data);
      this.setState({
          status: response.data.status,
          model: response.data.model,
          disease: response.data.disease,
          prediction: response.data.prediction,
      })
    })
  }

  onChange(e) {
    this.setState({
        file:e.target.files[0],
        previewimg:URL.createObjectURL(e.target.files[0])

    });
    
  }

  

  

  fileUpload(file){
    const url = 'https://backend-service-7zbu6hzb4a-et.a.run.app/upload?model=rice';
    const formData = new FormData();
    formData.append('predict-img',file)
    const config = {
        headers: {
            'content-type': 'multipart/form-data'
        }
    }
    return  post(url, formData,config)
  }
    render() { 
        if (this.state.status === 'success') {
            let index;
            if (this.state.model === 'rice') index = recommendations.rice.filter((n) => n.label === this.state.disease)[0];
            return (
                <section class="page-section" id="predict">
                
                        <Row xs={1} md={2} className="g-4">
                        <Col>
                            <Card>
                                <Card.Img variant="top" src={this.state.previewimg} />
                                <Card.Body>
                                <form onSubmit={this.onFormSubmit}>
                                <div className="my-3">
                                    <label htmlFor="formFile" className="form-label">Masukkan Gambar Daun Disini!</label>
                                    <input type="file" className="form-control" id="formFile" accept="image/*" onChange={this.onChange} />
                                    <button 
                                    tyoe="submit" className="btn btn-primary w-100 mt-2"><i class="fas fa-magnifying-glass me-1"></i>PREDIKSI</button>
                                </div>
                                </form>

                                </Card.Body>
                            </Card>
                        </Col>
                        <Col>
                            <Card>
                                <Card border="primary" >
                                    <Card.Header>Hasil Prediksi</Card.Header>
                                        <Card.Body>
                                            <Card.Text>
                                            <h4>Prediction Success</h4>
                                            <div >{this.state.prediction + '%'}</div>
                                            <h5>{this.state.disease}</h5>
                                            </Card.Text>
                                        </Card.Body>
                                </Card>
                            </Card>
                            <br/>
                            <Card>
                                <Card border="primary" >
                                    <Card.Header>Gejala</Card.Header>
                                        <Card.Body>
                                            <Card.Text>
                                            {index.desc}
                                            </Card.Text>
                                        </Card.Body>
                                </Card>
                            </Card>
                            <br/>
                            <Card>
                                <Card border="primary" >
                                    <Card.Header>Penyebab</Card.Header>
                                        <Card.Body>
                                            <Card.Text>
                                            {index.penyebab}
                                            </Card.Text>
                                        </Card.Body>
                                </Card>
                            </Card>
                            <br/>
                            <Card>
                                <Card border="primary" >
                                    <Card.Header>Cara</Card.Header>
                                        <Card.Body>
                                            <Card.Text>
                                            {index.cara}
                                            </Card.Text>
                                        </Card.Body>
                                </Card>
                            </Card>

                        </Col>
        
                        </Row>
                        
            </section>
            );
        } else {

        return (
            <>
            <Row xs={1} md={2} className="g-4">
        <Col>
            <Card>
                <Card.Img variant="top" src={this.state.previewimg}/>
                <Card.Body>
                <form onSubmit={this.onFormSubmit}>
                <div className="my-3">
                    <label htmlFor="formFile" className="form-label">Masukkan Gambar Daun Disini!</label>
                    <input type="file" className="form-control" id="formFile" accept="image/*" onChange={this.onChange} />
                    <button 
                     tyoe="submit" className="btn btn-primary w-100 mt-2"><i class="fas fa-magnifying-glass me-1"></i>PREDIKSI</button>
                </div>
                </form>

                </Card.Body>
            </Card>
        </Col>
        <Col>
                            <Card>
                            <Card border="primary" >
                                    <Card.Header>Tips!</Card.Header>
                                        <Card.Body>
                                            <Card.Text>
                                                <p> - Gambar yang dibutuhkan adalah gambar dengan format JPG</p>
                                                
                                                <p>- Ambil secara dekat gambar daun yang terkena penyakit agar lebih akurat!</p>
                                                
                                            </Card.Text>
                                        </Card.Body>
                                </Card>
                                <br/>
                                <Card border="primary" >
                                    <Card.Header>Hasil Prediksi</Card.Header>
                                        <Card.Body>
                                            <Card.Text>
                                                Hasil Prediksi akan Muncul Disini
                                            </Card.Text>
                                        </Card.Body>
                                </Card>
                            </Card>
                        </Col>
        
            </Row>
        </>
        );
        }
    }
}
 
export default Predict2;