import React from "react";
import axios from "axios";
import { useCart } from "react-use-cart";
import { Table } from "reactstrap";

const Itemcard = (props) => {
  const { addItem } = useCart();

  let id = props.item.f_Id;
  let deleteItem = () => {
    
    axios.delete(`http://localhost:8080/file/deleteFile/${id}`);
    window.location.href = "/Showfile";
     //navigate("/Showfile");
  };

  return (
          <>
      <table class="table table-striped">
      <tbody  >
    <tr  >
      <td >{props.item.fileName}</td>
      <td style={{ width :750}}>
      <button type="button" class="btn btn-danger" onClick={deleteItem}>
            Delete
          </button>
      </td>
    </tr>
  </tbody>
</table>
        </>
  );
};

export default Itemcard;
