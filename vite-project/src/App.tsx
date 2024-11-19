import { useState } from 'react';
import './App.css';
import { Card } from './components/card/card';
import { useCarroData } from './hooks/UseCarroData';
import { CreateModal } from './components/createModal/createModal';
import logo from './components/images/logo.png'; 

function App() {
  const { data } = useCarroData();
  const [isModalOpen, setIsModalOpen] = useState(false);

  const handleOpenModal = () => {
    setIsModalOpen(prev => !prev); 
  }


  
  return (
    <div>
    <img className="logoSize" src={logo} alt="Locadora de Carros" />  

    <div className='espacamento'>
      {isModalOpen && <CreateModal closeModal={handleOpenModal} />} 
      <button onClick={handleOpenModal}>Cadastrar Novo Veículo</button>

    </div>
      
    <div className="container">
      <div className="card-grid">
        {data?.map(CarroData => 
          <Card 
            key={CarroData.id} 
            marca={CarroData.marca} 
            modelo={CarroData.modelo}
            ano={CarroData.ano}
            combustao={CarroData.combustao}
            marchas={CarroData.marchas}
            urlImagem={CarroData.urlImagem}
            precoDiaria={CarroData.precoDiaria}
          />
        )}
      </div></div>
      
      
    </div>
  );
}

export default App;
