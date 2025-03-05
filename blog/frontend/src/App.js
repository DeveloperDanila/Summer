import logo from './logo-dark.svg';
import './App.css';
import {Component} from "react";

class App extends Component {
  state = {
    posts: []
  };

  async componentDidMount() {
    const response = await fetch('/api/v1/posts');
    const body = await response.json();
    this.setState({posts: body});
  }

  render() {
    const {posts} = this.state;
    return (
        <div className="App">
          <header className="App-header">
            <img src={logo} className="App-logo" alt="logo" />
            <div className="App-intro">
              <h2>posts</h2>
              {posts.map(post =>
                  <div key={post.id}>
                    {post.title} ({post.content})
                  </div>
              )}
            </div>
          </header>
        </div>
    );
  }
}
export default App;
