import React from 'react';
import './App.css';


class App extends React.Component {
  // public state = {
  //   showingDiv: 'show1'
  // }

  changeShowingState = (e: any) => {
    console.log(e)
    console.log(e.currentTarget.value)
    this.setState({
      showingDiv: e.currentTarget.value
    })
  }

  render() {
    return (
      <div className='App'>
        <nav className='flex-container'>
          <h1>Post a new job! </h1>

          <form action="/action_page.php">
            Address:
            <input type="text" name="address" value="address" />
            <br />

            Description:
            <input type="text" name="description" value="description" /><br />
            Due Date:
            <input type="date" name="dueDate" value="date" />
            <br /><br />
            Job Price:
            <input type="number" name="jobPrice" value="Earnings" />
            <br /><br />
            Product:
            <input type="number" name="product" value="What are they buying" />
            <br /><br />
            Product:
            <input type="text" name="productPrice" value="itemPrice" />
            <br /><br />
            Category:
            <input type="text" name="category" value="Item Category" />
            <br />
            Status:
            <input type="text" name="status" value="New" />
            <br />
            <input type="submit" value="Submit" />
            <input type="submit" value="Cancel" />
          </form>

        </nav>

        {
        }


      </div>
    )
  }
}


export default App;
