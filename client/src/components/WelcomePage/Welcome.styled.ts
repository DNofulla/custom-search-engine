import styled from "styled-components";

export const Container = styled.div`
  width: 100vw;
  height: 100vh;
  background-color: #121212;
  color: white;
  display: flex;
  justify-content: center;
  align-items: center;
`;

export const InnerContainer = styled.div`
  width: 40rem;
  height: 20rem;
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
`;

export const Image = styled.img`
  width: 300px;
  height: 300px;
  box-shadow: 0px 0px 5px 1px black;
  border-radius: 100%;
`;

export const H1 = styled.h1`
  margin-top: 1rem;
  margin-bottom: 1rem;
  font-size: 20pt;
`;

export const Form = styled.form`
  display: flex;
  justify-content: center;
  align-items: center;
`;

export const SubmitButton = styled.button`
  width: 10rem;
  height: 50px;
  margin-left: 10px;
  border-radius: 10px;
  background-color: #454ad8;
  border: none;
  outline: none;
  font-size: 16pt;
  color: white;
  box-shadow: 0px 0px 5px 1px black;
  cursor: pointer;

  &:hover {
    background-color: #00abc2;
  }
`;

export const Input = styled.input`
  width: 30rem;
  min-height: 50px;
  max-height: 50px;
  font-size: 16pt;
  padding-inline: 0.5rem;
  border-radius: 10px;
  border: none;
  box-shadow: 0px 0px 5px 5px black;
  color: black;
`;

export const AbsoluteContainer = styled.div`
  position: absolute;
  bottom: 0rem;
  width: 100%;
  height: 100px;
  display: flex;
  justify-content: center;
  align-items: center;
`;

export const CategoryButton = styled.div`
  margin-inline: 2rem;
  padding: 10px;
  background-color: #277fcc;
  color: white;
  border-radius: 5pt;
  cursor: pointer;
  box-shadow: 0px 0px 5px 1px black;

  &:hover {
    background-color: #0085fa;
  }
`;
