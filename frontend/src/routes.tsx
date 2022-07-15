import { Route, BrowserRouter } from  'react-router-dom';
import Usuario from 'pages/Usuarios';
import CriarUsuario from 'pages/criarUsuario';



const Routes = () => {
  return (
    <BrowserRouter>
      <Route component={CriarUsuario} exact path="/" />
      <Route component={Usuario} path="/usuarios" />
    </BrowserRouter>
  );
}
export default Routes;