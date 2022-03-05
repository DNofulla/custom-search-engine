import React, { useEffect, useState } from "react";
import Axios from "axios";
import { useNavigate, useParams } from "react-router";
import axios from "axios";

interface props {
  ip: String;
  setUser: (user: Object) => void;
}

const SearchResults = (props: props) => {
  const { categ, query } = useParams();

  const [category, setCategory] = useState(categ);
  const [searchQuery, setSearchQuery] = useState(query);
  const [data, setData] = useState({});
  const history = useNavigate();

  const submitSearch = (e: Event) => {
    e.preventDefault();
    history(`/results/${category}/${searchQuery}`);
  };

  const getData = async () => {
    axios
      .post("http://localhost:8080/search", {
        query: searchQuery,
        ipAddress: props.ip,
        category: category,
      })
      .then((response) => {
        console.log(response.data);
        props.setUser(response.data.user);
      })
      .catch((error) => {
        console.log(error);
      });
  };

  useEffect(() => {
    getData();
  }, []);

  return <>{}</>;
};

export default SearchResults;
