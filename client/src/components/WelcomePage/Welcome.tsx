import React, { FormEventHandler, useEffect, useState } from "react";
import {
  Container,
  InnerContainer,
  Image,
  H1,
  Input,
  Form,
  SubmitButton,
  AbsoluteContainer,
  CategoryButton,
} from "./Welcome.styled";
import logo from "../../images/Logos/android-chrome-512x512.png";
import Axios from "axios";
import { useNavigate } from "react-router";

interface props {
  user: Object | null;
  setUser: (user: Object) => void;
  ip: String;
  category: String;
}

const Welcome = (props: props) => {
  const [searchQuery, setSearchQuery] = useState("");
  const history = useNavigate();

  const handleChange = async (e: any) => {
    setSearchQuery(e.target.value);
  };

  const submitSearch = (e: Event) => {
    e.preventDefault();
    history(`/results/${props.category}/${searchQuery}`);
  };

  return (
    <>
      <Container>
        <InnerContainer>
          <Image src={logo} alt="XD" width="300px" />
          <H1>
            Dan Search Engine
            {props.category === "search"
              ? ""
              : " - " + props.category.toUpperCase()}
          </H1>
          <Form
            onSubmit={(e: any) => {
              submitSearch(e);
            }}
          >
            <Input
              type="text"
              placeholder="Search here!"
              value={searchQuery}
              onChange={handleChange}
            />
            <SubmitButton type="submit">Search!</SubmitButton>
          </Form>
          <div
            style={{
              marginTop: "0.25rem",
              fontSize: "14pt",
              color: "#454ad8",
              cursor: "pointer",
            }}
            onClick={() => {
              history("/history");
            }}
          >
            View my search history
          </div>
        </InnerContainer>
      </Container>
      <AbsoluteContainer>
        <CategoryButton onClick={() => history("/search")}>
          Regular
        </CategoryButton>
        <CategoryButton onClick={() => history("/images")}>
          Images
        </CategoryButton>
        <CategoryButton onClick={() => history("/news")}>News</CategoryButton>
      </AbsoluteContainer>
    </>
  );
};

export default Welcome;
