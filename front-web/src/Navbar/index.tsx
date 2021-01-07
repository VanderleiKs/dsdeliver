import './styles.css';
import {ReactComponent as Logo} from './logo.svg';

const Navbar = () => (

    <nav className="main-navbar">
        <Logo />
        <a className="logo-text">DS Delivery</a>
    </nav>
);

export default Navbar;