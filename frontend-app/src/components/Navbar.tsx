import React, {useState} from "react";
import {Link} from "react-router-dom";
import "./../style/navbar.css";
import Heart from "./icons/Heart";
import Cart from "./icons/Cart";

const Navbar = () => {
    const [query, setQuery] = useState<string>("");

    const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        setQuery(e.target.value);
    }

    return (
        <div className="py-125 px-3 border-bottom-light-gray">
            <div className="flex align-center justify-between">
                <div>
                    <Link to="/">OnlineStore</Link>
                </div>
                <div className="navbar-search-container">
                    <input className="navbar-search-input bg-light-gray border-light-gray border-1 border-solid border-radius-05 py-05 pl-1 pr-2"
                           value={query} onChange={handleChange} placeholder="Search" type="text" />
                </div>
                <nav className="flex align-center gap-1">
                    <Link className="flex align-center navbar-nav-button p-05" to="/cart">
                        <span className="sr-only">Shopping cart</span>
                        <Cart width={28} height={28} strokeWidth={1.5} />
                    </Link>
                    <Link className="flex align-center navbar-nav-button p-05" to="/favorite">
                        <span className="sr-only">Favorite products</span>
                        <Heart width={28} height={28} strokeWidth={1.5}/>
                    </Link>
                </nav>
            </div>
        </div>
    );
}

export default Navbar;
