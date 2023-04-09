import React from "react";
import Navbar from "../Navbar";
import "../../style/home.css";
import SortRow from "../Home/SortRow";
import ProductRow from "../Home/ProductRow";

const Home = () => {
    return (
        <div className="home-container flex flex-column">
            <header>
                <Navbar />
            </header>
            <main className="flex">
                <div className="flex flex-column filter-column border-right-light-gray">
                    <div className="h-35 flex align-center px-3 border-bottom-light-gray">
                        <h2>Filters</h2>
                    </div>
                </div>
                <div className="flex flex-column content-column">
                    <SortRow />
                    <ProductRow />
                </div>
            </main>
        </div>
    );
}

export default Home;
