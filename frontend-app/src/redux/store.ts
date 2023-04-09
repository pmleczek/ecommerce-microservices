import {configureStore} from "@reduxjs/toolkit";
import searchReducer from "./slice/searchSlice";
import userReducer from "./slice/userSlice";

const store = configureStore({
    reducer: {
        search: searchReducer,
        user: userReducer,
    },
});

export default store;
