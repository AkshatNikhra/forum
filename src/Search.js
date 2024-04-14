import React, {Component} from "react"; 

class Search extends Component{
    constructor(props){
        super(props);
        this.state = {searchQuery: ""};
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }
    handleChange(evt){
        this.setState({
            [evt.target.name]: evt.target.value
        })
    }
    handleSubmit(evt){
        evt.preventDefault();
        this.props.searchPost(this.state);
        this.setState({
            searchQuery: ""
        })
    }
    render(){
        return(
            <div>
                <h1>Search Component</h1>
                <form onSubmit={this.handleSubmit}>
                    <input 
                        type="text"
                        placeholder="Search"
                        name="searchQuery"
                        id="searchQuery"
                        value={this.state.searchQuery}
                        onChange={this.handleChange}
                    />
                    <button>Search</button>
                </form>
            </div>
        )
    }
}

export default Search;