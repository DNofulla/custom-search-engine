import Axios from "axios";
import React, { useEffect, useState } from "react";
import { Routes, Route } from "react-router-dom";
import SearchHistory from "./components/SearchHistory/SearchHistory";
import SearchResults from "./components/SearchResults/SearchResults";
import Welcome from "./components/WelcomePage/Welcome";
import { Navigate } from "react-router";

declare module "axios" {
  interface AxiosRequestConfig {
    ipAddress: String;
  }
}

const App = () => {
  const [ip, setIp] = useState("");
  const [user, setUser] = useState({});

  const getData = async () => {
    Axios.get("https://geolocation-db.com/json/")
      .then((res) => {
        setIp(res.data.IPv4);
        console.log(res.data);

        Axios.post("http://localhost:8080/history", {
          ipAddress: res.data.IPv4,
        })
          .then((res) => {
            console.log(res.data.user);
            setUser(res.data.user);
          })
          .catch((error) => {
            console.log(error);
          });
      })
      .catch((error) => {
        console.log(error);
      });
  };

  useEffect(() => {
    getData();
  }, []);

  return (
    <>
      <Routes>
        <Route path="/" element={<Navigate replace to="/search" />} />
        <Route
          path="/search"
          element={
            <Welcome user={user} setUser={setUser} ip={ip} category="search" />
          }
        />
        <Route
          path="/images"
          element={
            <Welcome user={user} setUser={setUser} ip={ip} category="images" />
          }
        />
        <Route
          path="/news"
          element={
            <Welcome user={user} setUser={setUser} ip={ip} category="news" />
          }
        />
        <Route
          path="/history"
          element={<SearchHistory user={user} setUser={setUser} ip={ip} />}
        />
        <Route
          path="/results/:categ/:query"
          element={<SearchResults setUser={setUser} ip={ip} />}
        />
        <Route path="*" element={<Navigate replace to="/" />} />
      </Routes>
    </>
  );
};

export default App;
