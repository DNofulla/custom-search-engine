import React from "react";
import {
  Container,
  InnerContainer,
  Image,
  H2,
  Input,
  Form,
  SubmitButton,
} from "./Welcome.styled";
import logo from "../../images/Logos/android-chrome-512x512.png";

const Welcome = () => {
  return (
    <>
      <Container>
        <InnerContainer>
          <Image src={logo} alt="XD" width="300px" />
          <H2>Dan Search Engine</H2>
          <Form
            onSubmit={(e) => {
              e.preventDefault();
              console.log("XD");
            }}
          >
            <Input type="text" />
            <SubmitButton type="submit">Search!</SubmitButton>
          </Form>
          <a href="#" style={{ marginTop: "0.25rem" }}>
            View my search history
          </a>
        </InnerContainer>
      </Container>
    </>
  );
};

export default Welcome;
