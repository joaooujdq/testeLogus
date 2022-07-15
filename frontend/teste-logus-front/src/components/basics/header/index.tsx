import './index.css'
import {Link} from 'react-router-dom'

const Header = () => {
    return (
        <>
         <header className="header mt-auto py-3 ">
     
  <div className="container" id="container-header">
  <Link to='/'>
    <button>Adicionar Usuário</button>
    </Link>
    <Link to='/usuarios'>
    <button>Usuários Cadastrados</button>
    </Link>
  </div>
     </header>
        </>
    );
}

export default Header;