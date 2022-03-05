import React, { useEffect, useState } from "react";
import Axios from "axios";

interface props {
  user: Object | null;
  setUser: (user: Object) => void;
  ip: String;
}

const SearchHistory = (props: props) => {
  const deleteOne = async () => {};

  const clearAll = async () => {};

  return (
    <>
      <div>GET USER PLZ</div>
    </>
  );
};

export default SearchHistory;
