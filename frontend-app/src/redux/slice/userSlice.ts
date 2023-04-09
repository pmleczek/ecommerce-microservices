import {createSlice} from "@reduxjs/toolkit";

interface State {
    auth: boolean;
    token: string;

}

const initialState: State = {
    auth: false,
    token: "",
};

const userSlice = createSlice({
    name: "user",
    initialState,
    reducers: {
        login: (state, action) => {
            state.auth = true;
            state.token = action.payload;
        },
        logout: (state, action) => {
            state.auth = false;
            state.token = "";
        }
    },
});

export default userSlice.reducer;
