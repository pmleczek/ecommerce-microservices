import {createSlice} from "@reduxjs/toolkit";

interface State {
    query: string;
}

const initialState: State = {
    query: "",
};

const searchSlice = createSlice({
    name: "search",
    initialState,
    reducers: {
        setQuery: (state, action) => {
            state.query = action.payload;
        },
    },
});

export default searchSlice.reducer;
