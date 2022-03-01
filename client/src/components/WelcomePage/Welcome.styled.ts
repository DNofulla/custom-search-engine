import styled from "styled-components";

export const Container = styled.div`
  width: 100vw;
  height: 100vh;
  background-color: black;
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
`;

export const H2 = styled.h2`
  margin-top: 1rem;
  margin-bottom: 1rem;
`;

export const Form = styled.form`
  display: flex;
  justify-content: center;
  align-items: center;
`;

export const SubmitButton = styled.button`
  width: 10rem;
  height: 40px;
  margin-left: 10px;
  border-radius: 10px;
  background-color: #5999ff;
  border: none;
  outline: none;
  font-size: 16pt;
  color: white;
`;

export const Input = styled.input`
  width: 30rem;
  min-height: 40px;
  max-height: 40px;
  font-size: 16pt;
  padding-inline: 0.5rem;
  border-radius: 10px;
  border: none;
`;
